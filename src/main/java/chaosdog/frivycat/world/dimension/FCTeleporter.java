package chaosdog.frivycat.world.dimension;

import chaosdog.frivycat.blocks.FCPortalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PortalInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.village.PointOfInterest;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.world.DimensionType;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public class FCTeleporter implements ITeleporter {
    private static final Method getRelativePortalPosition = ObfuscationReflectionHelper.findMethod(Entity.class, "func_241839_a", Direction.Axis.class, TeleportationRepositioner.Result.class);

    private final ServerWorld world;
    private final FCDimensionType dimension;
    private final FCPortalBlock portal;

    public FCTeleporter(ServerWorld world, FCDimensionType dimension, FCPortalBlock portal) {
        this.world = world;
        this.dimension = dimension;
        this.portal = portal;
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        boolean toDim = destWorld.getDimensionKey() == dimension.getKey();
        if(entity.world.getDimensionKey() != dimension.getKey() && !toDim) return null;
        else {
            WorldBorder border = destWorld.getWorldBorder();
            double minX = Math.max(-2.9999872E7D, border.minX() + 16.0D);
            double minZ = Math.max(-2.9999872E7D, border.minZ() + 16.0D);
            double maxX = Math.min(2.9999872E7D, border.maxX() - 16.0D);
            double maxZ = Math.min(2.9999872E7D, border.maxZ() - 16.0D);
            double offset = DimensionType.getCoordinateDifference(entity.world.getDimensionType(), destWorld.getDimensionType());
            BlockPos blockpos = new BlockPos(MathHelper.clamp(entity.prevPosX * offset, minX, maxX), entity.prevPosY, MathHelper.clamp(entity.prevPosZ * offset, minZ, maxZ));
            return getPortalLogic(entity, blockpos).map((portalres) -> {
                BlockPos entityPos = new BlockPos((int) entity.prevPosX, (int) entity.prevPosY, (int) entity.prevPosZ);
                BlockState state = entity.world.getBlockState(entityPos);
                Direction.Axis axis;
                Vector3d vector3d;
                axis = entity.getHorizontalFacing().getAxis();
                TeleportationRepositioner.Result result = TeleportationRepositioner.findLargestRectangle(entityPos, axis, 21, Direction.Axis.Y, 21, (pos) -> entity.world.getBlockState(pos) == state);
                try { vector3d = (Vector3d) getRelativePortalPosition.invoke(entity, axis, result); }
                catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                return getInfo(portalres, axis, vector3d, entity.getSize(entity.getPose()), entity.getMotion(), entity.rotationYaw, entity.rotationPitch);
            }).orElse(null);
        }
    }

    private static PortalInfo getInfo(TeleportationRepositioner.Result result, Direction.Axis axis, Vector3d offsetVector, EntitySize size, Vector3d motion, float rotationYaw, float rotationPitch) {
        BlockPos blockpos = result.startPos;
        double width = result.width;
        double height = result.height;
        double d2 = (double) size.width / 2.0D + (width - (double) size.width) * offsetVector.getX();
        double d3 = (height - (double) size.height) * offsetVector.getY();
        double d4 = 0.5D + offsetVector.getZ();
        boolean flag = axis == Direction.Axis.X;
        Vector3d vector3d1 = new Vector3d((double) blockpos.getX() + (flag ? d2 : d4), (double) blockpos.getY() + d3, (double) blockpos.getZ() + (flag ? d4 : d2));
        return new PortalInfo(vector3d1, motion, rotationYaw + 90, rotationPitch);
    }

    private Optional<TeleportationRepositioner.Result> getPortalLogic(Entity entity, BlockPos pos) {
        Optional<TeleportationRepositioner.Result> existing = getExistingPortal(entity, pos);

        if (entity instanceof ServerPlayerEntity) {
            if(existing.isPresent()) return existing;
            else {
                Direction.Axis axis = entity.getHorizontalFacing().getAxis();
                Optional<TeleportationRepositioner.Result> portal = makePortal(pos, axis);
                return portal;
            }
        }
        return existing;
    }

    private Optional<TeleportationRepositioner.Result> getExistingPortal(Entity entity, BlockPos pos) {
        PointOfInterestManager pointofinterestmanager = this.world.getPointOfInterestManager();
        int i = 128;
        pointofinterestmanager.ensureLoadedAndValid(this.world, pos, i);
        Optional<PointOfInterest> optional = pointofinterestmanager.getInSquare((poiType) -> poiType == dimension.getPointOfInterestType(), pos, i, PointOfInterestManager.Status.ANY).sorted(Comparator.<PointOfInterest>comparingDouble((poi) -> poi.getPos().distanceSq(pos)).thenComparingInt((poi) -> poi.getPos().getY())).filter((poi) -> this.world.getBlockState(poi.getPos()).matchesBlock(portal)).findFirst();
        return optional.map((poi) -> {
            BlockPos blockpos = poi.getPos();
            this.world.getChunkProvider().registerTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
            BlockState blockstate = this.world.getBlockState(blockpos);
            return TeleportationRepositioner.findLargestRectangle(blockpos, entity.getHorizontalFacing().getAxis(), 21, Direction.Axis.Y, 21, (posIn) -> this.world.getBlockState(posIn) == blockstate);
        });
    }

    private Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.getFacingFromAxis(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.world.getWorldBorder();
        int i = this.world.func_234938_ad_() - 1;
        BlockPos.Mutable startPos = pos.toMutable();

        for(BlockPos.Mutable portalPos : BlockPos.func_243514_a(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(i, this.world.getHeight(Heightmap.Type.MOTION_BLOCKING, portalPos.getX(), portalPos.getZ()));
            if (worldborder.contains(portalPos) && worldborder.contains(portalPos.move(direction, 1))) {
                portalPos.move(direction.getOpposite(), 1);

                for(int l = j; l >= 0; --l) {
                    portalPos.setY(l);
                    if (this.world.isAirBlock(portalPos)) {
                        int i1;
                        for(i1 = l; l > 0 && this.world.isAirBlock(portalPos.move(Direction.DOWN)); l--) { }

                        if (l + 4 <= i) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                portalPos.setY(l);
                                if (this.checkRegionForPlacement(portalPos, startPos, direction, 0)) {
                                    double d2 = pos.distanceSq(portalPos);
                                    if (this.checkRegionForPlacement(portalPos, startPos, direction, -1) && this.checkRegionForPlacement(portalPos, startPos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = portalPos.toImmutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = portalPos.toImmutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), MathHelper.clamp(pos.getY(), 70, this.world.func_234938_ad_() - 10), pos.getZ())).toImmutable();
            Direction direction1 = direction.rotateY();
            if (!worldborder.contains(blockpos)) return Optional.empty();

            for(int l1 = -1; l1 < 2; ++l1) {
                for(int k2 = 0; k2 < 2; ++k2) {
                    for(int i3 = -1; i3 < 3; ++i3) {
                        BlockState blockstate1 = i3 < 0 ? dimension.getFrameBlock().getDefaultState() : Blocks.AIR.getDefaultState();
                        startPos.setAndOffset(blockpos, k2 * direction.getXOffset() + l1 * direction1.getXOffset(), i3, k2 * direction.getZOffset() + l1 * direction1.getZOffset());
                        this.world.setBlockState(startPos, blockstate1);
                    }
                }
            }
        }

        for(int k1 = -1; k1 < 3; ++k1) {
            for(int i2 = -1; i2 < 4; ++i2) {
                if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
                    startPos.setAndOffset(blockpos, k1 * direction.getXOffset(), i2, k1 * direction.getZOffset());
                    this.world.setBlockState(startPos, dimension.getFrameBlock().getDefaultState(), 3);
                }
            }
        }

        BlockState blockstate = portal.getDefaultState();

        for(int j2 = 0; j2 < 2; ++j2) {
            for(int l2 = 0; l2 < 3; ++l2) {
                startPos.setAndOffset(blockpos, j2 * direction.getXOffset(), l2, j2 * direction.getZOffset());
                this.world.setBlockState(startPos, blockstate, 18);
            }
        }

        return Optional.of(new TeleportationRepositioner.Result(blockpos.toImmutable(), 2, 3));
    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.rotateY();

        for(int i = -1; i < 3; ++i) {
            for(int j = -1; j < 4; ++j) {
                offsetPos.setAndOffset(originalPos, directionIn.getXOffset() * i + direction.getXOffset() * offsetScale, j, directionIn.getZOffset() * i + direction.getZOffset() * offsetScale);
                if (j < 0 && !this.world.getBlockState(offsetPos).getMaterial().isSolid()) return false;
                if (j >= 0 && !this.world.isAirBlock(offsetPos)) return false;
            }
        }
        return true;
    }
}

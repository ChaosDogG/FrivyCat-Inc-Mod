package chaosdog.frivycat.blocks;

import chaosdog.frivycat.world.structure.dimension.FCDimensionType;
import chaosdog.frivycat.world.structure.dimension.FCTeleporter;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FCPortalBlock extends BreakableBlock {
    private final FCDimensionType dimension;

    public FCPortalBlock(FCDimensionType dimension) {
        super(Properties.from(Blocks.GLASS).doesNotBlockMovement());
        this.dimension = dimension;
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) world.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);

        for(int i = 0; i < 4; ++i) {
            double d0 = (double) pos.getX() + rand.nextDouble();
            double d1 = (double)pos.getY() + rand.nextDouble();
            double d2 = (double) pos.getZ() + rand.nextDouble();
            double d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (!world.getBlockState(pos.west()).matchesBlock(this) && !world.getBlockState(pos.east()).matchesBlock(this)) {
                d0 = (double) pos.getX() + 0.5D + 0.25D * (double)j;
                d3 = rand.nextFloat() * 2.0F * (float) j;
            }
            else {
                d2 = (double) pos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = rand.nextFloat() * 2.0F * (float) j;
            }
            world.addParticle(dimension.getPortalParticles(), d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(entity.hasPortalCooldown()) {
            entity.setPortalCooldown();
            return;
        }
        if (world instanceof ServerWorld && !entity.isPassenger() && !entity.isBeingRidden() && entity.canChangeDimension()) {
            RegistryKey<World> dim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, dimension.getName());
            RegistryKey<World> key = world.getDimensionKey() == dim ? World.OVERWORLD : dim;
            ServerWorld serverworld = ((ServerWorld)world).getServer().getWorld(key);
            if (serverworld == null) return;
            entity.changeDimension(serverworld, new FCTeleporter(serverworld, dimension, this));
            entity.setPortalCooldown();
        }
    }
}

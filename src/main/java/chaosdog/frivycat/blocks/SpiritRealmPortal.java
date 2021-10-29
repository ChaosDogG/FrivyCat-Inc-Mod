package chaosdog.frivycat.blocks;

import chaosdog.frivycat.world.FCTeleporter;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SpiritRealmPortal extends NetherPortalBlock {
    public SpiritRealmPortal(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getDimensionType().isNatural() && worldIn.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && random.nextInt(2000) < worldIn.getDifficulty().getId()) {
            while(worldIn.getBlockState(pos).matchesBlock(this)) {
                pos = pos.down();
            }

            if (worldIn.getBlockState(pos).canEntitySpawn(worldIn, pos, EntityType.ILLUSIONER)) {
                Entity entity = EntityType.ILLUSIONER.spawn(worldIn, null, null, null, pos.up(), SpawnReason.STRUCTURE, false, false);
                if (entity != null) {
                    entity.setPortalCooldown();
                }
            }
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

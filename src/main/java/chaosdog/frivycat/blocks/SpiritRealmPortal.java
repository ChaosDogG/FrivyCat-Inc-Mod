package chaosdog.frivycat.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
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
}

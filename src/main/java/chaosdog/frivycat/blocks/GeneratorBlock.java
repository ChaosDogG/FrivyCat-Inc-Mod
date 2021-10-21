package chaosdog.frivycat.blocks;

import net.minecraft.block.Block;

public class GeneratorBlock extends Block {
    public GeneratorBlock(Properties properties) {
        super(properties);
    }

    /*@Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        rand.nextInt(100);
        while(worldIn.getBlockState(pos).matchesBlock(this)) {
            pos = pos.down();
        }

        if(worldIn.getBlockState(pos).canEntitySpawn(worldIn, pos, EntityType.ITEM)) {
            Entity entity = EntityType.ITEM.spawn(worldIn, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, pos.up(), SpawnReason.STRUCTURE, false, false);
            if(entity != null) {
                entity.isBurning();
            }
        }
    }*/
}

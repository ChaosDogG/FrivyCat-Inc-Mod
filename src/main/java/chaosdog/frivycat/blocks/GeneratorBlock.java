package chaosdog.frivycat.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class GeneratorBlock extends Block {
    public GeneratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        rand.nextInt(100);
        while(worldIn.getBlockState(pos).matchesBlock(this)) {
            pos = pos.down();
        }

        if(worldIn.getBlockState(pos).canEntitySpawn(worldIn, pos, EntityType.ITEM)) {
            double d0 = (double)(worldIn.rand.nextFloat() * 0.7F) + (double)0.15F;
            double d1 = (double)(worldIn.rand.nextFloat() * 0.7F) + (double)0.060000002F + 0.6D;
            double d2 = (double)(worldIn.rand.nextFloat() * 0.7F) + (double)0.15F;
            ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, new ItemStack(Items.APPLE));
            itementity.setDefaultPickupDelay();
            worldIn.addEntity(itementity);
        }
    }
}

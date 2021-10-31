package chaosdog.frivycat.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
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
            Entity entity = EntityType.ITEM.spawn(worldIn, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, pos.up(), SpawnReason.STRUCTURE, false, false);
            if(entity != null) {
                entity.isBurning();
            }
        }
    }
}

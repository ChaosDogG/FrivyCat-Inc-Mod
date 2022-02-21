package chaosdog.frivycat.blocks;

import chaosdog.frivycat.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock.Properties;

public class MumboDustWire extends RedstoneWireBlock {

    public MumboDustWire(Properties properties) {
        super(properties);
    }

    protected boolean canThisConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        if (blockState.equals(ModBlocks.MUMBO_DUST_WIRE)) {
            return true;
        }
        if (blockState.equals(Blocks.REDSTONE_WIRE)) {
            return false;
        }
        return RedstoneWireBlock.canConnectTo(blockState, world, pos, side);
    }


}

package chaosdog.frivycat.blocks;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class SpiritFire extends AbstractFireBlock{
    public SpiritFire(AbstractBlock.Properties properties) {
        super(properties, 0.0f);
    }
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.canSurvive(stateIn, worldIn, currentPos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return shouldLightSpiritFire(worldIn.getBlockState(pos.down()).getBlock());
    }

    public static boolean shouldLightSpiritFire(Block block) {
        return block == Blocks.NETHERRACK;
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }
}



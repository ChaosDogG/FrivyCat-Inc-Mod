package chaosdog.frivycat.mixin;

import chaosdog.frivycat.ModBlocks;
import chaosdog.frivycat.blocks.SpiritFire;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public abstract class AbstractFireBlockMixin {

    @Inject(at = @At("HEAD"), method = "getShape", cancellable = true)
    private static void addCustomFire(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context, CallbackInfoReturnable<BlockState> cir){
        BlockPos blockpos = pos.down();
        BlockState blockstate = reader.getBlockState(blockpos);
        if(SpiritFire.shouldLightSpiritFire(blockstate.getBlock())) {
            cir.cancel();
            cir.setReturnValue(ModBlocks.SPIRIT_FIRE.get().getDefaultState());
        }
    }
}

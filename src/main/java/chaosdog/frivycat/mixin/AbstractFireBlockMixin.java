package chaosdog.frivycat.mixin;

//@Mixin(AbstractFireBlock.class)
//public abstract class AbstractFireBlockMixin {

/*    @Inject(at = @At("HEAD"), method = "getShape", cancellable = true)
    private static void addCustomFire(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context, CallbackInfoReturnable<BlockState> cir){
        BlockPos blockpos = pos.down();
        BlockState blockstate = reader.getBlockState(blockpos);
        if(SpiritFire.shouldLightSpiritFire(blockstate.getBlock())) {
            cir.cancel();
            cir.setReturnValue(ModBlocks.SPIRIT_FIRE.get().getDefaultState());
        }
    }*/
}

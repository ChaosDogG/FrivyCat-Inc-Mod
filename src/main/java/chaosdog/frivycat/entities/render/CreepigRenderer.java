package chaosdog.frivycat.entities.render;

/*public class CreepigRenderer extends MobRenderer<CreepigEntity, CreepigModel<CreepigEntity>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation(FrivyCatMod.ID, "textures/entity/cree-pig/cree-pig.png");

    public CreepigRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CreepigModel<>(), 0.5F);
        this.addLayer(new CreepigChargeLayer(this));
    }

    protected void preRenderCallback(CreepigEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        matrixStackIn.scale(f2, f3, f2);
    }

    protected float getOverlayProgress(CreepigEntity livingEntityIn, float partialTicks) {
        float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
        return (int) (f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
    }


    public ResourceLocation getEntityTexture(CreepigEntity entity) {
        return TEXTURES;
    }
}*/

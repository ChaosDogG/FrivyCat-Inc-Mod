package chaosdog.frivycat.entities.render;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.entities.model.PigperModel;
import chaosdog.frivycat.entities.passive.PigperEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.util.ResourceLocation;

public class PigperRenderer extends MobRenderer<PigperEntity, PigperModel<PigperEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(FrivyCatMod.ID, "textures/entity/pig-per/pig-per.png");

    public PigperRenderer(EntityRendererManager rendererManagerIn){
        super(rendererManagerIn, new PigperModel<>(0.5F), 0.7f);
        this.addLayer(new SaddleLayer<>(this, new PigperModel<>(0.5F), new ResourceLocation(FrivyCatMod.ID, "textures/entity/pig-per/pig-per_saddle.png")));
    }

    @Override
    public ResourceLocation getEntityTexture(PigperEntity entity) {
        return TEXTURE;
    }
}

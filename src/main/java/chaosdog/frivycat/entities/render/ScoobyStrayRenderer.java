package chaosdog.frivycat.entities.render;

import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.StayClothingLayer;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScoobyStrayRenderer extends ScoobySkeletonRenderer {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(FrivyCatMod.ID, "textures/entity/scooby_skeleton/scooby_stray.png");
    public ScoobyStrayRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn);
        this.addLayer(new StayClothingLayer<>(this));
    }

    public ResourceLocation getEntityTexture(AbstractSkeletonEntity entity) {
        return TEXTURE;
    }
}

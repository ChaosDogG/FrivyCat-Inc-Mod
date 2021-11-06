package chaosdog.frivycat.entities.render;

import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScoobySkeletonRenderer extends SkeletonRenderer {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(FrivyCatMod.ID, "textures/entity/scooby_skeleton/scooby_skeleton.png");

    public ScoobySkeletonRenderer(EntityRendererManager rendererManagerIn){
        super(rendererManagerIn);
    }
    @Override
    public ResourceLocation getEntityTexture(AbstractSkeletonEntity entity) {
        return TEXTURE;
    }
}

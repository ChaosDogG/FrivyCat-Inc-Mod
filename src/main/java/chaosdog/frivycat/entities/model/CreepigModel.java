package chaosdog.frivycat.entities.model;
// Made with Blockbench 4.0.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.swing.text.html.parser.Entity;

/*public class CreepigModel <T extends Entity> extends SegmentedModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer creepigArmor;
    private final ModelRenderer body;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;

    public CreepigModel() {
        this(0.0F);
    }

    public CreepigModel(float p_i46366_1_) {
        int i = 6;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, p_i46366_1_);
        this.head.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.creepigArmor = new ModelRenderer(this, 32, 0);
        this.creepigArmor.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, p_i46366_1_ + 0.5F);
        this.creepigArmor.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, p_i46366_1_);
        this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, p_i46366_1_);
        this.leg1.setRotationPoint(-2.0F, 18.0F, 4.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, p_i46366_1_);
        this.leg2.setRotationPoint(2.0F, 18.0F, 4.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, p_i46366_1_);
        this.leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, p_i46366_1_);
        this.leg4.setRotationPoint(2.0F, 18.0F, -4.0F);
    }

    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.head, this.body, this.leg1, this.leg2, this.leg3, this.leg4);
    }


    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}*/
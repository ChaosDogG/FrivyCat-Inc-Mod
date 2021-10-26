package chaosdog.frivycat.entities.model;
// Made with Blockbench 4.0.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


/*public class PigperModel <T extends PigperEntity> extends EntityModel<T> {
	private final ModelRenderer left_front;
	private final ModelRenderer right_front;
	private final ModelRenderer left_back;
	private final ModelRenderer right_back;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer head;

	public PigperModel() {
		textureWidth = 64;
		textureHeight = 32;

		left_front = new ModelRenderer(this);
		left_front.setRotationPoint(-3.0F, 18.0F, -5.0F);
		left_front.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		right_front = new ModelRenderer(this);
		right_front.setRotationPoint(3.0F, 18.0F, -5.0F);
		right_front.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		left_back = new ModelRenderer(this);
		left_back.setRotationPoint(-3.0F, 18.0F, 7.0F);
		left_back.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		right_back = new ModelRenderer(this);
		right_back.setRotationPoint(3.0F, 18.0F, 7.0F);
		right_back.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 11.0F, 2.0F);
		

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 1.5708F, 0.0F, 0.0F);
		body_r1.setTextureOffset(28, 8).addBox(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 12.0F, -6.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.body.rotateAngleX = ((float)Math.PI / 2F);
		this.right_back.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.left_back.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.right_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.left_front.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		left_front.render(matrixStack, buffer, packedLight, packedOverlay);
		right_front.render(matrixStack, buffer, packedLight, packedOverlay);
		left_back.render(matrixStack, buffer, packedLight, packedOverlay);
		right_back.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}*/
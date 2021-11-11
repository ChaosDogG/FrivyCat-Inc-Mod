package chaosdog.frivycat.entities.model;
// Made with Blockbench 4.0.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.entity.Entity;

public class PigperModel <T extends Entity> extends QuadrupedModel<T> {
	public PigperModel() {
		this(0.0F);
	}

	public PigperModel(float v) {
		super(6, v, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
	}
}
package chaosdog.frivycat.world.gen.structures;

import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;

import java.util.Random;

public abstract class TemplateFeature extends Feature<NoFeatureConfig> {
    public TemplateFeature() { super(NoFeatureConfig.CODEC); }

    protected final boolean genStructureFromTemplate(ResourceLocation templateName, ISeedReader reader, Random rand, BlockPos pos, ChunkGenerator generator, boolean postProcess, boolean singleChunk) {
        Template template = reader.getWorld().getStructureTemplateManager().getTemplate(templateName);

        if (template == null) {
            FrivyCatMod.LOG.error("Unable to generate " + templateName);
            return false;
        }

        PlacementSettings settings = new PlacementSettings();
        if(singleChunk) {
            ChunkPos chunkPos = new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4);
            settings.setChunk(chunkPos);
        }

        settings.setIgnoreEntities(false);

        FrivyCatMod.LOG.debug("Structure: " + templateName);
        FrivyCatMod.LOG.debug("Location: " + pos.getX() + " " + pos.getY() + " " + pos.getZ());

        // place the structure
        template.func_237144_a_(reader, pos, settings, rand);
        if (postProcess) postProcessStructure(template, reader, rand, pos, settings, generator);

        return true;
    }

    protected void postProcessStructure(Template template, ISeedReader reader, Random rand, BlockPos pos, PlacementSettings settings, ChunkGenerator generator) { }
}
package chaosdog.frivycat.world.gen.structures;

import chaosdog.frivycat.FCConfig;
import chaosdog.frivycat.world.FCWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.Template;

import java.util.Random;

public class DeathFellAccidentWaterStructure extends TemplateFeature {
    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        FCConfig.WorldGenOption settings = FCConfig.SETTINGS.structures.deathFellAccidentWater;
        if(rand.nextInt(settings.chance.get()) != 0 || !settings.enabled.get()) return false;
        ResourceLocation structure = new ResourceLocation("frivycat:death_fell_accident_water");
        Template template = reader.getWorld().getStructureTemplateManager().getTemplate(structure);
        int sizeX = template.getSize().getX();
        int sizeY = template.getSize().getY();
        int sizeZ = template.getSize().getZ();
        int level = FCWorld.getLowestY(reader, pos, pos.add(sizeX, sizeY, sizeZ));

        if (level < 63) return false; // if we're generating on the ground, the y level should never be below sea level
        BlockPos newPos = new BlockPos(pos.getX(), level - 25, pos.getZ());
        return genStructureFromTemplate(structure, reader, rand, newPos, generator, false, false);
    }
}

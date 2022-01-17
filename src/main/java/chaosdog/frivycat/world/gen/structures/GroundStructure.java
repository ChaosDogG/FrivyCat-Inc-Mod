package chaosdog.frivycat.world.gen.structures;

import chaosdog.frivycat.FCConfig;
import chaosdog.frivycat.world.FCWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraftforge.fml.ModList;

import java.util.Random;

// structure that generates a structure on the ground
public class GroundStructure extends TemplateFeature {
    private final ResourceLocation structure;
    private final int chance;
    private final boolean enabled;

    public GroundStructure(String name, FCConfig.WorldGenOption settings) {
        structure = new ResourceLocation(name);
        this.chance = settings.chance.get();
        this.enabled = settings.enabled.get();
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        //NetherNoah777: My mod will load ChaosDog's head monument if it is installed
        if (ModList.get().isLoaded("paradisemod") && structure.toString().equals("frivycat:chaos_head")) return false;
        if(rand.nextInt(chance) != 0 || !enabled) return false;
        Template template = reader.getWorld().getStructureTemplateManager().getTemplate(structure);
        int sizeX = template.getSize().getX();
        int sizeY = template.getSize().getY();
        int sizeZ = template.getSize().getZ();
        int level = FCWorld.getLowestY(reader, pos, pos.add(sizeX, sizeY, sizeZ));
        if (level < 63) return false; // if we're generating on the ground, the y level should never be below sea level
        BlockPos newPos = new BlockPos(pos.getX(), level + 1, pos.getZ());
        return genStructureFromTemplate(structure, reader, rand, newPos, generator, false, false);
    }
}

package chaosdog.frivycat.world.structure.structures;

import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

public class VillagerSpawnerStructure extends Structure<NoFeatureConfig> {
    public VillagerSpawnerStructure() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return null;
    }
}

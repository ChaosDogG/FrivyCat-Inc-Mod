package chaosdog.frivycat.world.structure.structures;

import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

public class ChaosHeadStructure extends Structure<NoFeatureConfig> {
    public ChaosHeadStructure() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return null;
    }
}

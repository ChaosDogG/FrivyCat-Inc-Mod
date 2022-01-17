package chaosdog.frivycat.world.gen.structures;

import chaosdog.frivycat.FCConfig;
import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.world.FCWorld;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FCStructures {
    private static final DeferredRegister<Feature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.FEATURES, FrivyCatMod.ID);

    private static final GroundStructure VILLAGER_SPAWNER_FEATURE = new GroundStructure("frivycat:villager_spawner", FCConfig.SETTINGS.structures.villagerSpawner);
    private static final GroundStructure CHAOS_HEAD_FEATURE = new GroundStructure("frivycat:chaos_head", FCConfig.SETTINGS.structures.chaosHead);
    private static final DeathFellAccidentWaterStructure DFAW_FEATURE = new DeathFellAccidentWaterStructure();

    public static final ConfiguredFeature<?, ?> VILLAGER_SPAWNER = getStructure("villager_spawner", VILLAGER_SPAWNER_FEATURE);
    public static final ConfiguredFeature<?, ?> CHAOS_HEAD = getStructure("chaos_head", CHAOS_HEAD_FEATURE);
    public static final ConfiguredFeature<?, ?> DFAW = getStructure("dfaw", DFAW_FEATURE);

    public static void init(IEventBus eventbus) {
        STRUCTURES.register(eventbus);
        STRUCTURES.register("villager_spawner_feature", () -> VILLAGER_SPAWNER_FEATURE);
        STRUCTURES.register("chaos_head_feature", () -> CHAOS_HEAD_FEATURE);
        STRUCTURES.register("dfaw_feature", () -> DFAW_FEATURE);
    }

    private static ConfiguredFeature<?, ?> getStructure(String name, Feature<NoFeatureConfig> basefeature) {
        return FCWorld.regConfFeature(name, basefeature.withConfiguration(NoFeatureConfig.INSTANCE));
    }
}

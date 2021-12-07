package chaosdog.frivycat.world.structure.dimension;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

import java.util.Arrays;
import java.util.List;

public enum FCLayer implements IAreaTransformer0 {
    PASSIVE_FIELDS(getPassiveFieldBiomes()),
    WOODED_TERRORS(getWoodedTerrorsBiomes()),
    SPIRIT_REALM(getSpiritRealmBiomes());

    private final List<RegistryKey<Biome>> biomes;

    FCLayer(List<RegistryKey<Biome>> biomes) {
        this.biomes = biomes;
    }

    @Override
    public int apply(INoiseRandom rand, int rand1, int rand2) {
        return FCLayerUtil.getBiomeID(biomes.get(rand.random(biomes.size())));
    }

    public final List<RegistryKey<Biome>> getBiomes() { return biomes; }

    private static List<RegistryKey<Biome>> getPassiveFieldBiomes() {
        return Arrays.asList(
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:peaceful_flower_forest")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:honest_plains")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:light_plains")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:curious_desert")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:drunken_ocean")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:depressed_badlands"))
        );
    }

    private static List<RegistryKey<Biome>> getWoodedTerrorsBiomes() {
        return Arrays.asList(
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:malicious_dark_forest")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:paranoid_end_highlands")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:enraged_nether_wastes")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:controlled_plains")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:insane_end_barrens")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:corrupted_basalt_deltas"))

        );
    }

    private static List<RegistryKey<Biome>> getSpiritRealmBiomes() {
        return Arrays.asList(
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:corrupted_basalt_deltas")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:controlled_plains")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:curious_desert")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:depressed_badlands")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:drunken_ocean")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:enraged_nether_wastes")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:honest_plains")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:insane_end_barrens")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:light_plains")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:malicious_dark_forest")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:paranoid_end_highlands")),
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:peaceful_flower_forest"))
        );
    }
}

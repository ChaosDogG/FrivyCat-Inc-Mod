package chaosdog.frivycat.world.biomeprovider;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.world.biomelayer.SpiritRealmLayer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiritRealmBiomeSource extends BiomeProvider {
    public static final Codec<SpiritRealmBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> builder.group(
                Codec.LONG.fieldOf("seed").stable().forGetter((source) -> source.seed),
                RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((source) -> source.biomeRegistry)
            ).apply(builder, builder.stable(SpiritRealmBiomeSource::new))
    );
    private static final ArrayList<RegistryKey<Biome>> biomes = new ArrayList<>(Arrays.asList(
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:co-bdeltas")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:co-plains")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:cu-desert")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:d-badlands")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:d-ocean")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:e-nwastes")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:h-plains")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:i-ebarrens")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:l-plains")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:m-dforest")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:p-ehighlands")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:p-fforest"))
    ));

    private final long seed;
    private final Registry<Biome> biomeRegistry;
    private final Layer genBiomes;

    public SpiritRealmBiomeSource(long seed, Registry<Biome> registry) {
        super(biomes.stream().map((key) -> () -> registry.getOrThrow(key)));
        this.seed = seed;
        biomeRegistry = registry;
        genBiomes = SpiritRealmLayer.genLayers(seed, registry);
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new SpiritRealmBiomeSource(seed, biomeRegistry);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int i = genBiomes.field_215742_b.getValue(x, z);
        Biome biome = biomeRegistry.getByValue(i);
        if (biome == null) {
            FrivyCatMod.LOG.error("Unknown biome id: " + i);
            throw new NullPointerException("Unknown biome id: " + i); // if this gets thrown, I need to do a git rollback...
        }
        return biome;
    }
}

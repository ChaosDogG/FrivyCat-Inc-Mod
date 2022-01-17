package chaosdog.frivycat.world.dimension;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.world.WorldSeed;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class FCBiomeSource extends BiomeProvider {
    public static final Codec<FCBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> builder.group(
                    Codec.STRING.fieldOf("group").stable().forGetter((source) -> source.layerName),
                    Codec.LONG.fieldOf("seed").stable().forGetter((source) -> source.seed),
                    RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((source) -> source.biomeRegistry)
            ).apply(builder, builder.stable(FCBiomeSource::new))
    );

    private final String layerName;
    private final Registry<Biome> biomeRegistry;
    private long seed;
    private final Layer genBiomes;

    public FCBiomeSource(String group, long seed, Registry<Biome> registry) {
        super(FCLayer.valueOf(group.toUpperCase()).getBiomes().stream().map((key) -> () -> registry.getOrThrow(key)));
        this.layerName = group;
        this.biomeRegistry = registry;
        this.seed = seed;
        if(seed == -1) this.seed = WorldSeed.getSeed();
        FrivyCatMod.LOG.debug("biome source seed for " + group + ": " + this.seed);
        try {
            FCLayer layer = FCLayer.valueOf(group.toUpperCase());
            this.genBiomes = FCLayerUtil.genLayers(seed, biomeRegistry, layer);
        }
        catch (IllegalArgumentException ex) {
            FrivyCatMod.LOG.error(group + " is not a valid biome source group!");
            throw new IllegalStateException(group + " is not a valid biome source group!");
        }
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new FCBiomeSource(layerName, seed, biomeRegistry);
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

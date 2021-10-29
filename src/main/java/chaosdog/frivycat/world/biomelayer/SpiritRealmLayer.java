package chaosdog.frivycat.world.biomelayer;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.LongFunction;

public class SpiritRealmLayer implements IAreaTransformer0 {
    private static Registry<Biome> biomeRegistry;

    protected ArrayList<RegistryKey<Biome>> commonBiomes = new ArrayList<>(Arrays.asList(
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:l-plains")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:cu-desert")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:d-ocean")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:p-fforest")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:h-plains"))
    ));

    protected ArrayList<RegistryKey<Biome>> uncommonBiomes = new ArrayList<>(Arrays.asList(
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:m-dforest")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:i-ebarrens"))
    ));

    protected ArrayList<RegistryKey<Biome>> rareBiomes = new ArrayList<>(Arrays.asList(
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:co-plains")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:co-bdeltas")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:p-ehighlands")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:e-nwastes")),
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("frivycat:d-badlands"))
    ));

    @Override
    public int apply(INoiseRandom rand, int rand1, int rand2) {
        if (rand.random(16) == 0) return getBiomeID(rareBiomes.get(rand.random(rareBiomes.size())));
        else if (rand.random(8) == 0) return getBiomeID(uncommonBiomes.get(rand.random(uncommonBiomes.size())));
        else return getBiomeID(commonBiomes.get(rand.random(commonBiomes.size())));
    }

    protected static int getBiomeID(RegistryKey<Biome> key) {
        Biome biome = biomeRegistry.getValueForKey(key);
        return biomeRegistry.getId(biome);
    }

    private static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> genLayers2(LongFunction<C> ctxFactory, Registry<Biome> registry) {
        biomeRegistry = registry;

        IAreaFactory<T> biomes = new SpiritRealmLayer().apply(ctxFactory.apply(1L));

        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1000), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1001), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1002), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1003), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1004), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1005), biomes);

        biomes = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomes, 1, ctxFactory);

        return biomes;
    }

    public static Layer genLayers(long seed, Registry<Biome> registry) {
        biomeRegistry = registry;
        IAreaFactory<LazyArea> areaFactory = genLayers2((contextSeed) -> new LazyAreaLayerContext(25, seed, 1L), registry);
        return new Layer(areaFactory);
    }
}

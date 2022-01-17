package chaosdog.frivycat.world.dimension;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.LongFunction;

public class FCLayerUtil {
    private static Registry<Biome> biomeRegistry;

    protected static int getBiomeID(RegistryKey<Biome> key) {
        Biome biome = biomeRegistry.getValueForKey(key);
        return biomeRegistry.getId(biome);
    }

    private static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> genLayers2(LongFunction<C> ctxFactory, Registry<Biome> registry, FCLayer layer) {
        biomeRegistry = registry;

        IAreaFactory<T> biomes = layer.apply(ctxFactory.apply(1L));

        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1000), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1001), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1002), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1003), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1004), biomes);
        biomes = ZoomLayer.NORMAL.apply(ctxFactory.apply(1005), biomes);

        biomes = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomes, 1, ctxFactory);

        return biomes;
    }

    public static Layer genLayers(long seed, Registry<Biome> registry, FCLayer layer) {
        biomeRegistry = registry;
        IAreaFactory<LazyArea> areaFactory = genLayers2((contextSeed) -> new LazyAreaLayerContext(25, seed, 1L), registry, layer);
        return new Layer(areaFactory);
    }
}

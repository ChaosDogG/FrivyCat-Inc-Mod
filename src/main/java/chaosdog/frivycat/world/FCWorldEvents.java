package chaosdog.frivycat.world;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.world.gen.ModEntityGeneration;
import chaosdog.frivycat.world.gen.structures.FCStructures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = FrivyCatMod.ID)
public class FCWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());

        List<Supplier<ConfiguredFeature<?, ?>>> structureGen = event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES);
        structureGen.add(() -> FCStructures.CHAOS_HEAD);
        structureGen.add(() -> FCStructures.VILLAGER_SPAWNER);
        structureGen.add(() -> FCStructures.DFAW);
        ModEntityGeneration.onEntitySpawn(event);
    }
}

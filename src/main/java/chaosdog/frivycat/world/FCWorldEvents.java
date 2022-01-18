package chaosdog.frivycat.world;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.entities.ModEntityTypes;
import chaosdog.frivycat.world.gen.structures.FCStructures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = FrivyCatMod.ID)
public class FCWorldEvents {

    @SubscribeEvent
    public static void initWorldGen(final BiomeLoadingEvent event) {
        // structure generation
        List<Supplier<ConfiguredFeature<?, ?>>> structureGen = event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES);
        structureGen.add(() -> FCStructures.CHAOS_HEAD);
        structureGen.add(() -> FCStructures.VILLAGER_SPAWNER);
        structureGen.add(() -> FCStructures.DFAW);

        // mob spawns
        MobSpawnInfoBuilder spawnInfo = event.getSpawns();

        switch(event.getName().toString()) {
            case "minecraft:plains":
                spawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.PIGPER.get(), 20, 1, 4));
                break;

            case "minecraft:dark_forest": case "minecraft:dark_forest_hills":
                spawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityTypes.SCOOBY_SKELETON.get(), 20, 1, 4));
                break;

            case "minecraft:snowy_tundra":
                spawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityTypes.SCOOBY_STRAY.get(), 20, 1, 4));
                break;
        }
    }
}

package chaosdog.frivycat;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.ai.brain.task.GiveHeroGiftsTask;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.coremod.api.ASMAPI;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;
import java.util.Map;

public class Villagers {
    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, FrivyCatMod.ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, FrivyCatMod.ID);

    public static final RegistryObject<PointOfInterestType> DUMMY_POI = POINT_OF_INTEREST_TYPES.register("dummy",
            () -> new PointOfInterestType("dummy", PointOfInterestType.getAllStates(DummyBlocks.DUMMY_A.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> DUMMY = VILLAGER_PROFESSIONS.register("dummy",
            () -> new VillagerProfession("dummy", DUMMY_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH));

    private static void heroLoot()
    {
        try{
            String name = ASMAPI.mapField("field_220403_a");
            Field field = GiveHeroGiftsTask.class.getDeclaredField(name);
            field.setAccessible(true);
            Map<VillagerProfession, ResourceLocation> value = (Map<VillagerProfession, ResourceLocation>) field.get(null);
            value.put(DUMMY, new ResourceLocation(FrivyCatMod.ID, "gameplay/hero_of_the_village/dummy_gift"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init(IEventBus eventBus) {
        POINT_OF_INTEREST_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
        FrivyCatMod.LOGGER.info("Setting up villager professions");
    }
}

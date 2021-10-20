package chaosdog.frivycat;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Villagers {
    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, FrivyCatMod.ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, FrivyCatMod.ID);

    public static final RegistryObject<PointOfInterestType> DUMMY_A_POI = POINT_OF_INTEREST_TYPES.register("dummy_a",
            () -> new PointOfInterestType("dummy", PointOfInterestType.getAllStates(DummyBlocks.DUMMY_A.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> DUMMY_A = VILLAGER_PROFESSIONS.register("dummy_a",
            () -> new VillagerProfession("dummy_a", DUMMY_A_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH));

    public static final RegistryObject<PointOfInterestType> DUMMY_B_POI = POINT_OF_INTEREST_TYPES.register("dummy_b",
            () -> new PointOfInterestType("dummy_b", PointOfInterestType.getAllStates(DummyBlocks.DUMMY_B.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> DUMMY_B = VILLAGER_PROFESSIONS.register("dummy_b",
            () -> new VillagerProfession("dummy_b", DUMMY_B_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH));

    public static final RegistryObject<PointOfInterestType> DUMMY_C_POI = POINT_OF_INTEREST_TYPES.register("dummy_c",
            () -> new PointOfInterestType("dummy_c", PointOfInterestType.getAllStates(DummyBlocks.DUMMY_C.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> DUMMY_C = VILLAGER_PROFESSIONS.register("dummy_c",
            () -> new VillagerProfession("dummy_c", DUMMY_C_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH));

    public static void init(IEventBus eventBus) {
        POINT_OF_INTEREST_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
        FrivyCatMod.LOG.info("Setting up villager professions");
    }
}

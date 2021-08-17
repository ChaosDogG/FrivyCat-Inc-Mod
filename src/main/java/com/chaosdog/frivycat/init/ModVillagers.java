package com.chaosdog.frivycat.init;

import com.chaosdog.frivycat.FrivyCatMod;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, FrivyCatMod.ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, FrivyCatMod.ID);

    public static final RegistryObject<PointOfInterestType> DUMMY_POI = POINT_OF_INTEREST_TYPES.register("dummy",
            () -> new PointOfInterestType("dummy", PointOfInterestType.getAllStates(ModBlocks.DUMMY_A.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> DUMMY = VILLAGER_PROFESSIONS.register("dummy",
            () -> new VillagerProfession("dummy", DUMMY_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH));
    public static void registerDummyPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, DUMMY_POI.get());
        }catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void fillTradeData() {
        VillagerTrades.ITrade[] dummyLevel1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(ModBlocks.DUMMY_A, 1, 1, 1, 1)
        };
        VillagerTrades.ITrade[] dummyLevel2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(ModBlocks.DUMMY_A, 1, 1, 1, 1)
        };
        VillagerTrades.ITrade[] dummyLevel3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(ModBlocks.DUMMY_A, 1, 1, 1, 1)
        };
        VillagerTrades.ITrade[] dummyLevel4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(ModBlocks.DUMMY_A, 1, 1, 1, 1)
        };
        VillagerTrades.ITrade[] dummyLevel5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(ModBlocks.DUMMY_A, 1, 1, 1, 1)
        };
        VillagerTrades.VILLAGER_DEFAULT_TRADES.put(DUMMY.get(),toIntMap(ImmutableMap.of(1,dummyLevel1,2,dummyLevel2,3,dummyLevel3,4,dummyLevel4,5,dummyLevel5)));
    }

    private static Int2ObjectMap<VillagerTrades.ITrade[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }

    public static void init(IEventBus eventBus) {
    }
}

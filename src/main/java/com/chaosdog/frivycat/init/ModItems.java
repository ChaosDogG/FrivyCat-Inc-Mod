package com.chaosdog.frivycat.init;

import com.chaosdog.frivycat.FrivyCatMod;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    public static final RegistryObject<Item> SCOOBY_SNACK = ITEMS.register("scooby_snack", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(
            new Food.Builder()
                    .nutrition(2)
                    .saturationMod(1)
                    .meat()
                    .build()
    )));
    public static final RegistryObject<Item> AGATE = ITEMS.register("agate", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> CORRUPTED_DIAMOND = ITEMS.register("corrupted_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> COTTON_CANDY_STRAND = ITEMS.register("cotton_candy_strand", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> CULTIST_DIAMOND = ITEMS.register("cultist_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> DARK_DIAMOND = ITEMS.register("dark_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> EASTER_EGG = ITEMS.register("easter_egg", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> FIRE_DIAMOND = ITEMS.register("fire_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> GREEN_APPLE_CANDY = ITEMS.register("green_apple_candy", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> HOLY_DIAMOND = ITEMS.register("holy_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> JASPER = ITEMS.register("jasper", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> LIGHTNING_DIAMOND = ITEMS.register("lightning_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> MADNESS_DIAMOND = ITEMS.register("madness_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> MAGE_BOOK = ITEMS.register("mage_book", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> MIC = ITEMS.register("mic", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> PEACE_DIAMOND = ITEMS.register("peace_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> PENCIL = ITEMS.register("pencil", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> SHADOW_DIAMOND = ITEMS.register("shadow_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> SPINEL = ITEMS.register("spinel", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> VETERAN_DIAMOND = ITEMS.register("veteran_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> VINE_DIAMOND = ITEMS.register("vine_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> WATER_DIAMOND = ITEMS.register("water_diamond", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package com.chaosdog.frivycat.init;

import com.chaosdog.frivycat.FrivyCatMod;
import com.chaosdog.frivycat.items.ShinyItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // foods
    public static final RegistryObject<Item> SCOOBY_SNACK = ITEMS.register("scooby_snack", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(
            new Food.Builder()
                    .hunger(2)
                    .saturation(1f)
                    .fastToEat()
                    .build()
    )));
    public static final RegistryObject<Item> COTTON_CANDY_STRAND = ITEMS.register("cotton_candy_strand", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(
            new Food.Builder()
                    .hunger(2)
                    .saturation(1f)
                    .fastToEat()
                    .build()
    )));
    public static final RegistryObject<Item> GREEN_APPLE_CANDY = ITEMS.register("green_apple_candy", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(
            new Food.Builder()
                    .hunger(4)
                    .saturation(2f)
                    .meat()
                    .build()
    )));
    public static final RegistryObject<Item> HONEY_MUG = ITEMS.register("honey_mug", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).food(
        new Food.Builder()
                .hunger(12)
                .saturation(2f)
                .meat()
                .build()
    )));

    // other items
    public static final RegistryObject<Item> EASTER_EGG = ITEMS.register("easter_egg", () -> new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MIC = ITEMS.register("mic", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PENCIL = ITEMS.register("pencil", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(150)));
    public static final RegistryObject<Item> RED_TEA_BUCKET = ITEMS.register("red_tea_bucket", () -> new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> LOCK_PICK = ITEMS.register("lock_pick", () -> new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> MUMBO_DUST = ITEMS.register("mumbo_dust", () -> new Item(new Item.Properties().group(ItemGroup.REDSTONE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BABY_RATTLE_BOY = ITEMS.register("baby_rattle_boy", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_RATTLE_GIRL = ITEMS.register("baby_rattle_girl", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_BOTTLE = ITEMS.register("baby_bottle", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

    // gemstones
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> JASPER = ITEMS.register("jasper", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SPINEL = ITEMS.register("spinel", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> AGATE = ITEMS.register("agate", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));

    // items with the enchanted glint
    public static final RegistryObject<Item> DARK_DIAMOND = ITEMS.register("dark_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SHADOW_DIAMOND = ITEMS.register("shadow_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CULTIST_DIAMOND = ITEMS.register("cultist_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> FIRE_DIAMOND = ITEMS.register("fire_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> LIGHTNING_DIAMOND = ITEMS.register("lightning_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> PEACE_DIAMOND = ITEMS.register("peace_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> VINE_DIAMOND = ITEMS.register("vine_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> VETERAN_DIAMOND = ITEMS.register("veteran_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> HOLY_DIAMOND = ITEMS.register("holy_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> WATER_DIAMOND = ITEMS.register("water_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> MADNESS_DIAMOND = ITEMS.register("madness_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CORRUPTED_DIAMOND = ITEMS.register("corrupted_diamond", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> MAGE_BOOK = ITEMS.register("mage_book", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand", () -> new ShinyItem(new Item.Properties().group(ItemGroup.MISC)));

    // stone banana (work in progress)
    public static final RegistryObject<Item> STONE_BANANA = ITEMS.register("stone_banana", () -> new Item(new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.EPIC)));

    // potion filled mug (WiP)
    public static final RegistryObject<Item> POTION_MUG = ITEMS.register("potion_mug", () -> new Item(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));
    public static final RegistryObject<Item> MUG = ITEMS.register("mug", () -> new Item(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

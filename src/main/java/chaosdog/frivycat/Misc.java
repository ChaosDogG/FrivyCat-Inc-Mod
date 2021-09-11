package chaosdog.frivycat;

import chaosdog.frivycat.items.EasterEgg;
import chaosdog.frivycat.items.LockPick;
import chaosdog.frivycat.items.ShinyItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Misc {
    // item registry (does not need to be public)
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // foods
    public static final RegistryObject<Item> SCOOBY_SNACK = regFood("scooby_snack", 64, 2, 1f, true, true, Rarity.EPIC);
    public static final RegistryObject<Item> COTTON_CANDY_STRAND = regFood("cotton_candy_strand", 64, 2, 1f, true, false, Rarity.COMMON);
    public static final RegistryObject<Item> GREEN_APPLE_CANDY = regFood("green_apple_candy", 64, 4, 2f, false, true, Rarity.COMMON);
    public static final RegistryObject<Item> HONEY_MUG = regFood("honey_mug", 1, 12, 2f, false, true, Rarity.COMMON);

    // other items
    public static final RegistryObject<Item> EASTER_EGG = Utils.regItem(ITEMS, "easter_egg", new EasterEgg(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MIC = Utils.regItem(ITEMS, "mic", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PENCIL = Utils.regItem(ITEMS,"pencil", new Item(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(150)));
    public static final RegistryObject<Item> RED_TEA_BUCKET = Utils.regItem(ITEMS,"red_tea_bucket", new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> LOCK_PICK = Utils.regItem(ITEMS,"lock_pick", new LockPick(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(300)));
    public static final RegistryObject<Item> MUMBO_DUST = Utils.regItem(ITEMS,"mumbo_dust", new Item(new Item.Properties().group(ItemGroup.REDSTONE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BABY_RATTLE_BOY = Utils.regItem(ITEMS,"baby_rattle_boy", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_RATTLE_GIRL = Utils.regItem(ITEMS,"baby_rattle_girl", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_BOTTLE = Utils.regItem(ITEMS,"baby_bottle", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> MAGE_BOOK = Utils.regItem(ITEMS,"mage_book", new ShinyItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> MAGIC_WAND = Utils.regItem(ITEMS,"magic_wand", new ShinyItem(new Item.Properties().group(ItemGroup.MISC)));

    // stone banana (work in progress)
    public static final RegistryObject<Item> STONE_BANANA = Utils.regItem(ITEMS,"stone_banana", new Item(new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.EPIC)));

    // potion filled mug (WIP)
    public static final RegistryObject<Item> POTION_MUG = Utils.regItem(ITEMS,"potion_mug", new Item(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));
    public static final RegistryObject<Item> MUG = Utils.regItem(ITEMS,"mug", new Item(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOGGER.info("Setting up everything else");
        // register the item registry object
        ITEMS.register(eventBus);
    }

    // generates and registers a food item
    private static RegistryObject<Item> regFood(String name, int stackSize, int hungerPoints, float saturation, boolean isFast, boolean wolfFood, Rarity rarity) {
        Food.Builder food_props = new Food.Builder().hunger(hungerPoints).saturation(saturation);
        if (isFast)
            food_props = food_props.fastToEat();

        if (wolfFood)
            food_props = food_props.meat();

        Item.Properties properties = new Item.Properties().rarity(rarity).group(ItemGroup.FOOD).food(food_props.build()).maxStackSize(stackSize);

        return Utils.regItem(ITEMS, name, new Item(properties));
    }
}

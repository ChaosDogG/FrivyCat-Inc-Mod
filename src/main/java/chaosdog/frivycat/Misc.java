package chaosdog.frivycat;

import chaosdog.frivycat.items.*;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class Misc {
    // item registry (does not need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // foods
    public static final RegistryObject<Item> SCOOBY_SNACK = regFood("scooby_snack", 64, 2, 1f, true, true, Rarity.EPIC);
    public static final RegistryObject<Item> COTTON_CANDY_STRAND = regFood("cotton_candy_strand", 64, 2, 1f, true, false, Rarity.COMMON);
    public static final RegistryObject<Item> GREEN_APPLE_CANDY = regFood("green_apple_candy", 64, 4, 2f, false, false, Rarity.COMMON);
    public static final RegistryObject<Item> HONEY_MUG = regHoneyMug("honey_mug", 1, 12, 2f, false, false, Rarity.COMMON);

    // other items
    public static final RegistryObject<Item> EASTER_EGG = Utils.regItem(ITEMS, "easter_egg", new EasterEgg(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> MIC = Utils.regItem(ITEMS, "mic", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PENCIL = Utils.regItem(ITEMS,"pencil", new Item(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(150)));
    public static final RegistryObject<Item> RED_TEA_BUCKET = Utils.regItem(ITEMS,"red_tea_bucket", new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> BABY_RATTLE_BOY = regBabyRattle("boy");
    public static final RegistryObject<Item> BABY_RATTLE_GIRL = regBabyRattle("girl");
    public static final RegistryObject<Item> LOCK_PICK = Utils.regItem(ITEMS,"lock_pick", new LockPick(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(300)));
    public static final RegistryObject<Item> MUMBO_DUST = Utils.regItem(ITEMS, "mumbo_dust", new Item(new Item.Properties().group(ItemGroup.REDSTONE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BABY_BOTTLE = Utils.regItem(ITEMS,"baby_bottle", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> MAGE_BOOK = Utils.regItem(ITEMS,"mage_book", new ShinyItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> MAGIC_WAND = Utils.regItem(ITEMS,"magic_wand", new ShinyItem(new Item.Properties().group(ItemGroup.MISC)));

    // stone banana (work in progress)
    public static final RegistryObject<Item> STONE_BANANA = Utils.regItem(ITEMS,"stone_banana", new StoneBanana(7.0f, -2.0f, ItemTier.STONE, (new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.EPIC))));

    // potion filled mug (WIP)
    public static final RegistryObject<Item> POTION_MUG = Utils.regItem(ITEMS,"potion_mug", new PotionMug(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));
    public static final RegistryObject<Item> MUG = Utils.regItem(ITEMS,"mug", new Mug(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOGGER.info("Setting up everything else");
        // register the item registry object
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

    // generates and registers food items
    private static RegistryObject<Item> regFood(String name, int stackSize, int hungerPoints, float saturation, boolean isFast, boolean wolfFood, Rarity rarity) {
        Food.Builder food_props = new Food.Builder().hunger(hungerPoints).saturation(saturation);
        if (isFast)
            food_props = food_props.fastToEat();

        if (wolfFood)
            food_props = food_props.meat();

        Item.Properties properties = new Item.Properties().rarity(rarity).group(ItemGroup.FOOD).food(food_props.build()).maxStackSize(stackSize);

        return Utils.regItem(ITEMS, name, new Item(properties));
    }

    private static RegistryObject<Item> regHoneyMug(String name, int stackSize, int hungerPoints, float saturation, boolean isFast, boolean wolfFood, Rarity rarity) {
        Food.Builder food_props = new Food.Builder().hunger(hungerPoints).saturation(saturation);
        if (isFast)
            food_props = food_props.fastToEat();

        if (wolfFood)
            food_props = food_props.meat();

        Item.Properties properties = new Item.Properties().rarity(rarity).group(ItemGroup.FOOD).food(food_props.build()).maxStackSize(stackSize);

        return Utils.regItem(ITEMS, name, new HoneyMug(properties));
    }

    // generates and registers baby rattles
    private static RegistryObject<Item> regBabyRattle(String gender) {
        return Utils.regItem(ITEMS, "baby_rattle_" + gender,
                new Item(new Item.Properties().group(ItemGroup.MISC)){
                    @Override
                    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                        if (gender.equals("boy")) tooltip.add(new TranslationTextComponent("item.frivycat.baby_rattle_boy.tooltip").mergeStyle(TextFormatting.AQUA));
                        if (gender.equals("girl")) tooltip.add(new TranslationTextComponent("item.frivycat.baby_rattle_girl.tooltip").mergeStyle(TextFormatting.LIGHT_PURPLE));
                        super.addInformation(stack, worldIn, tooltip, flagIn);
                    }
                });
    }

    //private static RegistryObject<Item> regWire(Block blockIn, Item.Properties properties) {
    //     return Utils.regBlockWithItem(BLOCKS, ITEMS, blockIn, properties);
    // }
    //
}

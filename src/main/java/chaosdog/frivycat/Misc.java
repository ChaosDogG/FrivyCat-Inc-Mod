package chaosdog.frivycat;

import chaosdog.frivycat.entities.ModEntityTypes;
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
    public static final RegistryObject<Item> SCOOBY_SNACK = Utils.regItem(ITEMS,"scooby_snack", new Item(new Item.Properties().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(ModFoods.SCOOBY_SNACK)));
    public static final RegistryObject<Item> COTTON_CANDY_STRAND = Utils.regItem(ITEMS,"cotton_candy_strand", new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.COTTON_CANDY_STRAND)));
    public static final RegistryObject<Item> GREEN_APPLE_CANDY = Utils.regItem(ITEMS,"green_apple_candy", new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.GREEN_APPLE_CANDY)));
    public static final RegistryObject<Item> HONEY_MUG = Utils.regItem(ITEMS,"honey_mug", new HoneyMug(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.HONEY_MUG).maxStackSize(1)));

    // other items
    public static final RegistryObject<Item> EASTER_EGG = Utils.regItem(ITEMS, "easter_egg", new EasterEgg(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RED_TEA_BUCKET = Utils.regItem(ITEMS,"red_tea_bucket", new RedTeaBucket(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    public static final RegistryObject<Item> BABY_RATTLE_BOY = regBabyRattle("boy");
    public static final RegistryObject<Item> BABY_RATTLE_GIRL = regBabyRattle("girl");
    public static final RegistryObject<Item> BABY_BOTTLE = Utils.regItem(ITEMS,"baby_bottle", new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> MUMBO_DUST = Utils.regItem(ITEMS, "mumbo_dust", new Item(new Item.Properties().group(ItemGroup.REDSTONE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DISPENSER_BOW = Utils.regItem(ITEMS, "dispenser_bow", new Item(new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.UNCOMMON)));

    // tools (work in progress)
    //TODO should allow player to edit signs on right-click if Quark is not installed
    public static final RegistryObject<Item> PENCIL = Utils.regItem(ITEMS,"pencil", new Item(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(150)));
    //TODO can "record" a mob's cries to be played in a jukebox/note block
    public static final RegistryObject<Item> MIC = Utils.regItem(ITEMS, "mic", new Item(new Item.Properties().group(ItemGroup.MISC)));
    //TODO TBD
    public static final RegistryObject<Item> MAGE_BOOK = Utils.regItem(ITEMS,"mage_book", new ShinyItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
    //TODO various magical things
    public static final RegistryObject<Item> MAGIC_WAND = Utils.regItem(ITEMS,"magic_wand", new MagicWand(new Item.Properties().group(ItemGroup.MISC).maxDamage(500)));
    public static final RegistryObject<Item> BUTTER = Utils.regItem(ITEMS, "butter", new Butter(new Item.Properties().group(ItemGroup.MISC)));
    //TODO should forcefully open locked chest
    public static final RegistryObject<Item> LOCK_PICK = Utils.regItem(ITEMS,"lock_pick", new LockPick(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(300)));
    public static final RegistryObject<Item> STONE_BANANA = Utils.regItem(ITEMS,"stone_banana", new StoneBanana(7.0f, -2.0f, ItemTier.STONE, (new Item.Properties().group(ItemGroup.TOOLS).rarity(Rarity.EPIC))));

    // potion filled mug (WIP)
    public static final RegistryObject<Item> POTION_MUG = Utils.regItem(ITEMS,"potion_mug", new PotionMug(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));
    public static final RegistryObject<Item> MUG = Utils.regItem(ITEMS,"mug", new Mug(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));

    // mustaches
    public static final RegistryObject<Item> MUSTACHE = Utils.regItem(ITEMS, "mustache", new Mustache(new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> MUMBO_MUSTACHE = Utils.regItem(ITEMS, "mumbo_mustache", new Mustache(new Item.Properties().group(ItemGroup.COMBAT)));

    // capsules
    public static final RegistryObject<ModSpawnEggItem> PIGPER_SPAWN_EGG = Utils.regItem(ITEMS, "pigper_spawn_egg", new ModSpawnEggItem(ModEntityTypes.PIGPER, 0x0da70b, 0x90413f, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> SCOOBY_SKELETON_SPAWN_EGG = Utils.regItem(ITEMS, "scooby_skeleton_spawn_egg", new ModSpawnEggItem(ModEntityTypes.SCOOBY_SKELETON, 0x53462d, 0x6a5a39, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> SCOOBY_STRAY_SPAWN_EGG = Utils.regItem(ITEMS, "scooby_stray_spawn_egg", new ModSpawnEggItem(ModEntityTypes.SCOOBY_STRAY, 0x827a53, 0xa49b70, new Item.Properties().group(ItemGroup.MISC)));

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOG.info("Setting up everything else");
        // register the item registry object
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }


    // generates and registers baby rattles
    private static RegistryObject<Item> regBabyRattle(String gender) {
        return Utils.regItem(ITEMS, "baby_rattle_" + gender,
                new Item(new Item.Properties().group(ItemGroup.MISC)){
                    @Override
                    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                        if (gender.equals("boy")) tooltip.add(new TranslationTextComponent("item.frivycat.baby_rattle_boy.tooltip").mergeStyle(TextFormatting.AQUA));
                        if (gender.equals("girl")) tooltip.add(new TranslationTextComponent("item.frivycat.baby_rattle_girl.tooltip").mergeStyle(TextFormatting.LIGHT_PURPLE));
                    }
                });
    }

    //private static RegistryObject<Item> regWire(Block blockIn, Item.Properties properties) {
    //     return Utils.regBlockWithItem(BLOCKS, ITEMS, blockIn, properties);
    // }
    //
}

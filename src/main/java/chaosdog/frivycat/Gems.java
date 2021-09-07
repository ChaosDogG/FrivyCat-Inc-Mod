package chaosdog.frivycat;

import chaosdog.frivycat.items.ShinyItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Gems {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // gemstones
    public static final RegistryObject<Item> RUBY = regGem("ruby");
    public static final RegistryObject<Item> SAPPHIRE = regGem("sapphire");
    public static final RegistryObject<Item> ZIRCON = regGem("zircon");
    public static final RegistryObject<Item> GARNET = regGem("garnet");
    public static final RegistryObject<Item> JADE = regGem("jade");
    public static final RegistryObject<Item> JASPER = regGem("jasper");
    public static final RegistryObject<Item> SPINEL = regGem("spinel");
    public static final RegistryObject<Item> TOPAZ = regGem("topaz");
    public static final RegistryObject<Item> AGATE = regGem("agate");

    // special diamonds
    public static final RegistryObject<Item> CORRUPTED_DIAMOND = regSpecialDiamond("corrupted_diamond");
    public static final RegistryObject<Item> CULTIST_DIAMOND = regSpecialDiamond("cultist_diamond");
    public static final RegistryObject<Item> DARK_DIAMOND = regSpecialDiamond("dark_diamond");
    public static final RegistryObject<Item> FIRE_DIAMOND = regSpecialDiamond("fire_diamond");
    public static final RegistryObject<Item> HOLY_DIAMOND = regSpecialDiamond("holy_diamond");
    public static final RegistryObject<Item> LIGHTNING_DIAMOND = regSpecialDiamond("lightning_diamond");
    public static final RegistryObject<Item> MADNESS_DIAMOND = regSpecialDiamond("madness_diamond");
    public static final RegistryObject<Item> PEACE_DIAMOND = regSpecialDiamond("peace_diamond");
    public static final RegistryObject<Item> SHADOW_DIAMOND = regSpecialDiamond("shadow_diamond");
    public static final RegistryObject<Item> VETERAN_DIAMOND = regSpecialDiamond("veteran_diamond");
    public static final RegistryObject<Item> VINE_DIAMOND = regSpecialDiamond("vine_diamond");
    public static final RegistryObject<Item> WATER_DIAMOND = regSpecialDiamond("water_diamond");

    // gem blocks
    public static final RegistryObject<Block> RUBY_BLOCK = regGemBlock("ruby");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = regGemBlock("sapphire");
    public static final RegistryObject<Block> ZIRCON_BLOCK = regGemBlock("zircon");
    public static final RegistryObject<Block> GARNET_BLOCK = regGemBlock("garnet");
    public static final RegistryObject<Block> JADE_BLOCK = regGemBlock("jade");
    public static final RegistryObject<Block> JASPER_BLOCK = regGemBlock("jasper");
    public static final RegistryObject<Block> SPINEL_BLOCK = regGemBlock("spinel");
    public static final RegistryObject<Block> TOPAZ_BLOCK = regGemBlock("topaz");
    public static final RegistryObject<Block> AGATE_BLOCK = regGemBlock("agate");

    // gem ores
    public static final RegistryObject<Block> RUBY_ORE = regGemOre("ruby");
    public static final RegistryObject<Block> SAPPHIRE_ORE = regGemOre("sapphire");
    public static final RegistryObject<Block> ZIRCON_ORE = regGemOre("zircon");
    public static final RegistryObject<Block> GARNET_ORE = regGemOre("garnet");
    public static final RegistryObject<Block> JADE_ORE = regGemOre("jade");
    public static final RegistryObject<Block> JASPER_ORE = regGemOre("jasper");
    public static final RegistryObject<Block> SPINEL_ORE = regGemOre("spinel");
    public static final RegistryObject<Block> TOPAZ_ORE = regGemOre("topaz");
    public static final RegistryObject<Block> AGATE_ORE = regGemOre("agate");

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOGGER.info("Setting up Gems and Special Diamonds");
        // register the registries
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
    }

    // registers a gem block
    private static RegistryObject<Block> regGemBlock(String name) {
        return Utils.regBlockWithItem(BLOCKS, ITEMS, name + "_block", new Block(AbstractBlock.Properties.from(Blocks.EMERALD_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    }

    // registers a gem ore block
    private static RegistryObject<Block> regGemOre(String name) {
        return Utils.regBlockWithItem(BLOCKS, ITEMS, name + "_ore", new OreBlock(AbstractBlock.Properties.from(Blocks.EMERALD_ORE)), ItemGroup.BUILDING_BLOCKS);
    }



    // registers a gemstone item
    private static RegistryObject<Item> regGem(String name) {
        return Utils.regItem(ITEMS, name, new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    }

    // registers a special diamond item
    private static RegistryObject<Item> regSpecialDiamond(String name) {
        return Utils.regItem(ITEMS, name, new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    }
}

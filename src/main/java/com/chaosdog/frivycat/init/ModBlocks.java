package com.chaosdog.frivycat.init;

import com.chaosdog.frivycat.FrivyCatMod;
import com.chaosdog.frivycat.Utils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

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

    //dummy blocks
    public static final RegistryObject<Block> DUMMY_A = regDummyBlock("a");
    public static final RegistryObject<Block> DUMMY_B = regDummyBlock("b");
    public static final RegistryObject<Block> DUMMY_C = regDummyBlock("c");

    public static void init(IEventBus eventBus) {
        // register the registries
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }

    // registers a gem block
    private static RegistryObject<Block> regGemBlock(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL);
        return Utils.regBlockWithItem(BLOCKS, BLOCK_ITEMS, name + "_block", new Block(properties), ItemGroup.BUILDING_BLOCKS);
    }

    // registers a gem block
    private static RegistryObject<Block> regGemOre(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.STONE);
        return Utils.regBlockWithItem(BLOCKS, BLOCK_ITEMS, name + "_ore", new Block(properties), ItemGroup.BUILDING_BLOCKS);
    }

    // registers a dummy block
    private static RegistryObject<Block> regDummyBlock(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.IRON).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL);
        return Utils.regBlockWithItem(BLOCKS, BLOCK_ITEMS, "dummy_" + name, new Block(properties), ItemGroup.MISC);
    }
}

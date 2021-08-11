package com.chaosdog.frivycat;

import com.chaosdog.frivycat.init.ModBlocks;
import com.chaosdog.frivycat.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("frivycat")
public class FrivyCatMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ID = "frivycat";

    public FrivyCatMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.init(eventBus);
        ModBlocks.init(eventBus);

        // put debug stick and knowledge book in tools tab of creative inventory
        changeCreativeTab(Items.DEBUG_STICK.asItem(), ItemGroup.TOOLS);
        changeCreativeTab(Items.KNOWLEDGE_BOOK, ItemGroup.TOOLS);

        // add jigsaw, structure, and command blocks to the redstone tab
        changeCreativeTab(Blocks.JIGSAW, ItemGroup.REDSTONE);
        changeCreativeTab(Blocks.STRUCTURE_BLOCK, ItemGroup.REDSTONE);
        changeCreativeTab(Blocks.STRUCTURE_VOID, ItemGroup.REDSTONE);
        changeCreativeTab(Blocks.COMMAND_BLOCK.asItem(), ItemGroup.REDSTONE);
        changeCreativeTab(Blocks.CHAIN_COMMAND_BLOCK, ItemGroup.REDSTONE);
        changeCreativeTab(Blocks.REPEATING_COMMAND_BLOCK, ItemGroup.REDSTONE);

        // add monster spawner to decorations tab
        changeCreativeTab(Blocks.SPAWNER, ItemGroup.DECORATIONS);

        // add barrier to building blocks tab
        changeCreativeTab(Blocks.BARRIER, ItemGroup.BUILDING_BLOCKS);

        // add command block minecarts to transportation tab
        changeCreativeTab(Items.COMMAND_BLOCK_MINECART, ItemGroup.TRANSPORTATION);

        // add Suspicious Stew to food tab
        changeCreativeTab(Items.SUSPICIOUS_STEW, ItemGroup.FOOD);
    }

    // sets or changes the creative tab of a vanilla item
    public static void changeCreativeTab(Item item, ItemGroup tab) {
        ObfuscationReflectionHelper.setPrivateValue(Item.class, item, tab,"group");
    }

    // sets or changes the creative tab of a vanilla block
    public static void changeCreativeTab(Block block, ItemGroup tab) {
        ObfuscationReflectionHelper.setPrivateValue(Item.class, block.asItem(), tab,"group");
    }
}

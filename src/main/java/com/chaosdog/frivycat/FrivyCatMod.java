package com.chaosdog.frivycat;

import com.chaosdog.frivycat.init.ModBlocks;
import com.chaosdog.frivycat.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        //ModVillagers.init(eventBus); commented until issues within the registry are resolved

        // put debug stick and knowledge book in tools tab of creative inventory
        Utils.changeCreativeTab(Items.DEBUG_STICK.asItem(), ItemGroup.TOOLS);
        Utils.changeCreativeTab(Items.KNOWLEDGE_BOOK, ItemGroup.TOOLS);

        // add jigsaw, structure, and command blocks to the redstone tab
        Utils.changeCreativeTab(Blocks.JIGSAW, ItemGroup.REDSTONE);
        Utils.changeCreativeTab(Blocks.STRUCTURE_BLOCK, ItemGroup.REDSTONE);
        Utils.changeCreativeTab(Blocks.STRUCTURE_VOID, ItemGroup.REDSTONE);
        Utils.changeCreativeTab(Blocks.COMMAND_BLOCK.asItem(), ItemGroup.REDSTONE);
        Utils.changeCreativeTab(Blocks.CHAIN_COMMAND_BLOCK, ItemGroup.REDSTONE);
        Utils.changeCreativeTab(Blocks.REPEATING_COMMAND_BLOCK, ItemGroup.REDSTONE);

        // add monster spawner to decorations tab
        Utils.changeCreativeTab(Blocks.SPAWNER, ItemGroup.DECORATIONS);

        // add barrier to building blocks tab
        Utils.changeCreativeTab(Blocks.BARRIER, ItemGroup.BUILDING_BLOCKS);

        // add command block minecarts to transportation tab
        Utils.changeCreativeTab(Items.COMMAND_BLOCK_MINECART, ItemGroup.TRANSPORTATION);

        // add Suspicious Stew to food tab
        Utils.changeCreativeTab(Items.SUSPICIOUS_STEW, ItemGroup.FOOD);
    }
}

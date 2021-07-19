package com.chaosdog.frivycat;

import com.chaosdog.frivycat.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.client.event.ColorHandlerEvent;
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

        // put debug stick in misc tab of creative inventory
        ObfuscationReflectionHelper.setPrivateValue(Item.class,Items.DEBUG_STICK.asItem(), ItemGroup.TAB_MISC,"category");

        // add jigsaw, structure, and command blocks to the redstone tab
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.JIGSAW.asItem(), ItemGroup.TAB_REDSTONE,"category");
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.STRUCTURE_BLOCK.asItem(), ItemGroup.TAB_REDSTONE,"category");
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.STRUCTURE_VOID.asItem(), ItemGroup.TAB_REDSTONE,"category");
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.COMMAND_BLOCK.asItem(), ItemGroup.TAB_REDSTONE,"category");
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.CHAIN_COMMAND_BLOCK.asItem(), ItemGroup.TAB_REDSTONE,"category");
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.REPEATING_COMMAND_BLOCK.asItem(), ItemGroup.TAB_REDSTONE,"category");

        // add monster spawner to decorations tab
        ObfuscationReflectionHelper.setPrivateValue(Item.class, Blocks.SPAWNER.asItem(), ItemGroup.TAB_DECORATIONS,"category");
    }
}

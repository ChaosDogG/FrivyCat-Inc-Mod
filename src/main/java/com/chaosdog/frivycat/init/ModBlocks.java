package com.chaosdog.frivycat.init;

import com.chaosdog.frivycat.FrivyCatMod;
import com.chaosdog.frivycat.Utils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // gem blocks
    public static final RegistryObject<Block> RUBY_BLOCK = regGemBlock("ruby");

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
}

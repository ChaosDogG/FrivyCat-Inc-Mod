package chaosdog.frivycat;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;

public class Utils {
    // sets or changes the creative tab of a vanilla item
    public static void changeCreativeTab(Item item, ItemGroup tab) {
        ObfuscationReflectionHelper.setPrivateValue(Item.class, item, tab,"group");
    }

    // sets or changes the creative tab of a vanilla block
    public static void changeCreativeTab(Block block, ItemGroup tab) {
        ObfuscationReflectionHelper.setPrivateValue(Item.class, block.asItem(), tab,"group");
    }

    // register a block (no item)
    public static <B extends Block> RegistryObject<B> regBlock(DeferredRegister<Block> block_registry, String name, B block) {
        return block_registry.register(name, () -> block);
    }

    // register a block with an item
    public static <B extends Block> RegistryObject<B> regBlockWithItem(DeferredRegister<Block> block_registry, DeferredRegister<Item> item_registry, String name, B block, ItemGroup tab) {
        RegistryObject<B> toReturn = block_registry.register(name, () -> block);
        item_registry.register(name, () -> new BlockItem(block, new Item.Properties().group(tab)));
        return toReturn;
    }

    // register an item
    public static <I extends Item> RegistryObject<I> regItem(DeferredRegister<Item> item_registry, String name, I item) {
        return item_registry.register(name, () -> item);
    }
}

package chaosdog.frivycat;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // Mumbo stuff
    public static final RegistryObject<Block> MUMBO_DUST_WIRE = Utils.regBlock(BLOCKS, "mumbo_dust_wire", new Block(AbstractBlock.Properties.from(net.minecraft.block.Blocks.REDSTONE_WIRE)));
    public static final RegistryObject<Block> MUMBO_BLOCK = Utils.regBlockWithItem(BLOCKS, ITEMS, "mumbo_block", new Block(AbstractBlock.Properties.from(net.minecraft.block.Blocks.REDSTONE_BLOCK)), ItemGroup.REDSTONE);

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOGGER.info("Setting up dummy blocks");
        // register the registries
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
    }


}

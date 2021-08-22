package chaosdog.frivycat;

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

public class DummyBlocks {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    //dummy blocks
    public static final RegistryObject<Block> DUMMY_A = regDummyBlock("a");
    public static final RegistryObject<Block> DUMMY_B = regDummyBlock("b");
    public static final RegistryObject<Block> DUMMY_C = regDummyBlock("c");

    public static void init(IEventBus eventbus) {
        // register the registries
        eventbus.register(BLOCKS);
        eventbus.register(ITEMS);
    }

    // registers a dummy block
    private static RegistryObject<Block> regDummyBlock(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.IRON).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL);
        return Utils.regBlockWithItem(BLOCKS, ITEMS, "dummy_" + name, new Block(properties), ItemGroup.MISC);
    }
}

package chaosdog.frivycat;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class DummyBlocks {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    //dummy blocks
    public static final RegistryObject<Block> DUMMY_A = regDummyBlock("a");
    public static final RegistryObject<Block> DUMMY_B = regDummyPillar("b");
    public static final RegistryObject<Block> DUMMY_C = regDummyFrontFace("c");

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOGGER.info("Setting up dummy blocks");
        // register the registries
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
    }

    // registers a dummy block
    private static RegistryObject<Block> regDummyBlock(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.IRON).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL);
        return Utils.regBlockWithItem(BLOCKS, ITEMS, "dummy_" + name, new Block(properties), ItemGroup.MISC);
    }
    private static RegistryObject<Block> regDummyPillar(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.IRON).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL);
        return Utils.regBlockWithItem(BLOCKS, ITEMS, "dummy_" + name, new RotatedPillarBlock(properties), ItemGroup.MISC);
    }
    private static RegistryObject<Block> regDummyFrontFace(String name) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(Material.IRON).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f).sound(SoundType.METAL);
        return Utils.regBlockWithItem(BLOCKS, ITEMS, "dummy_" + name, new AbstractFurnaceBlock(properties) {
            @Nullable
            @Override
            public TileEntity createNewTileEntity(IBlockReader worldIn) {
                return null;
            }

            @Override
            protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {

            }
        }, ItemGroup.MISC);
    }
}

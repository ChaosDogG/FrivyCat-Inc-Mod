package chaosdog.frivycat;

import chaosdog.frivycat.blocks.CorruptedBlock;
import chaosdog.frivycat.blocks.GeneratorBlock;
import chaosdog.frivycat.blocks.MumboBlock;
import chaosdog.frivycat.blocks.MumboDustWire;
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
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // Mumbo stuff
    public static final RegistryObject<Block> MUMBO_DUST_WIRE = Utils.regBlock(BLOCKS, "mumbo_dust_wire", new MumboDustWire(AbstractBlock.Properties.from(net.minecraft.block.Blocks.REDSTONE_WIRE)));
    public static final RegistryObject<Block> MUMBO_BLOCK = Utils.regBlockWithItem(BLOCKS, ITEMS, "mumbo_block", new MumboBlock(AbstractBlock.Properties.from(net.minecraft.block.Blocks.REDSTONE_BLOCK)), ItemGroup.REDSTONE);

    //Custom stuff
    public static final RegistryObject<Block> CORRUPTED_BLOCK = Utils.regBlockWithItem(BLOCKS, ITEMS, "corrupted_block", new CorruptedBlock(AbstractBlock.Properties.create(Material.TNT).harvestLevel(0).hardnessAndResistance(0f, 10000f).sound(SoundType.SLIME).doesNotBlockMovement()), ItemGroup.DECORATIONS);

    //Generator stuff
    //TODO make these blocks spawn their respected item/item type
    public static final RegistryObject<Block> LOG_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "log_generator", new GeneratorBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)), ItemGroup.MISC);
    public static final RegistryObject<Block> IRON_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "iron_generator", new GeneratorBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)), ItemGroup.MISC);
    public static final RegistryObject<Block> APPLE_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "apple_generator", new GeneratorBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)), ItemGroup.MISC);
    public static final RegistryObject<Block> GOLD_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "gold_generator", new GeneratorBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)), ItemGroup.MISC);
    public static final RegistryObject<Block> DIAMOND_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "diamond_generator", new GeneratorBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)), ItemGroup.MISC);
    public static final RegistryObject<Block> OBSIDIAN_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "obsidian_generator", new GeneratorBlock(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)), ItemGroup.MISC);

    //Fires
    //public static final RegistryObject<Block> SPIRIT_FIRE = Utils.regBlock(BLOCKS, "spirit_fire", new SpiritFire(AbstractBlock.Properties.from(Blocks.FIRE)));

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOG.info("Setting up blocks");
        // register the registries
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
    }

    /*public static void initClient(){
        RenderTypeLookup.setRenderLayer(SPIRIT_FIRE.get(), RenderType.getCutout());
    }*/


}

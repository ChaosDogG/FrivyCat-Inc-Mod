package chaosdog.frivycat;

import chaosdog.frivycat.blocks.CorruptedBlock;
import chaosdog.frivycat.blocks.GeneratorBlock;
import chaosdog.frivycat.blocks.MumboBlock;
import chaosdog.frivycat.items.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // Mumbo stuff
    //public static final RegistryObject<Block> MUMBO_DUST_WIRE = Utils.regBlock(BLOCKS, "mumbo_dust_wire", new MumboDustWire(AbstractBlock.Properties.from(net.minecraft.block.Blocks.REDSTONE_WIRE)));
    public static final RegistryObject<Block> MUMBO_BLOCK = Utils.regBlockWithItem(BLOCKS, ITEMS, "mumbo_block", new MumboBlock(Block.Properties.from(net.minecraft.world.level.block.Blocks.REDSTONE_BLOCK)), CreativeModeTab.TAB_REDSTONE);

    //Custom stuff
    public static final RegistryObject<Block> CORRUPTED_BLOCK = Utils.regBlockWithItem(BLOCKS, ITEMS, "corrupted_block", new CorruptedBlock(Block.Properties.create(Material.EXPLOSIVE).harvestLevel(0).hardnessAndResistance(0f, 10000f).sound(SoundType.SLIME_BLOCK).doesNotBlockMovement()), CreativeModeTab.TAB_DECORATIONS);

    //Generator stuff
    public static final RegistryObject<Block> LOG_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "log_generator", new GeneratorBlock(GeneratorBlock.Type.LOG), ModItemGroup.WIP);
    public static final RegistryObject<Block> IRON_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "iron_generator", new GeneratorBlock(GeneratorBlock.Type.IRON), ModItemGroup.WIP);
    public static final RegistryObject<Block> APPLE_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "apple_generator", new GeneratorBlock(GeneratorBlock.Type.APPLE), ModItemGroup.WIP);
    public static final RegistryObject<Block> GOLD_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "gold_generator", new GeneratorBlock(GeneratorBlock.Type.GOLD), ModItemGroup.WIP);
    public static final RegistryObject<Block> DIAMOND_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "diamond_generator", new GeneratorBlock(GeneratorBlock.Type.DIAMOND), ModItemGroup.WIP);
    public static final RegistryObject<Block> OBSIDIAN_GENERATOR = Utils.regBlockWithItem(BLOCKS, ITEMS, "obsidian_generator", new GeneratorBlock(GeneratorBlock.Type.OBSIDIAN), ModItemGroup.WIP);

    //Fires
    //public static final RegistryObject<Block> SPIRIT_FIRE = Utils.regBlock(BLOCKS, "spirit_fire", new SpiritFire(AbstractBlock.Properties.from(Blocks.FIRE)));

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOG.info("Setting up blocks");
        // register the registries
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
    }

    public static void initClient(){
        //RenderTypeLookup.setRenderLayer(SPIRIT_FIRE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(APPLE_GENERATOR.get(), RenderType.getCutout());
    }


}

package chaosdog.frivycat;

import chaosdog.frivycat.entities.ModEntityTypes;
import chaosdog.frivycat.entities.render.PigperRenderer;
import chaosdog.frivycat.entities.render.ScoobySkeletonRenderer;
import chaosdog.frivycat.entities.render.ScoobyStrayRenderer;
import chaosdog.frivycat.paintings.ModPaintings;
import chaosdog.frivycat.world.FCWorld;
import chaosdog.frivycat.world.dimension.FCBiomeSource;
import chaosdog.frivycat.world.dimension.FCDimensions;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod("frivycat")
public class FrivyCatMod {
    public static final Logger LOG = LogManager.getLogger();
    public static final String ID = "frivycat";

    public FrivyCatMod() {
        LOG.info("Setting up Frivy Cat mod");
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FCConfig.initConfig(ModLoadingContext.get());
        LOG.info("Loaded config");

        // modules
        Gems.init(eventBus);
        SpecialDiamonds.init(eventBus);
        DummyBlocks.init(eventBus);
        Villagers.init(eventBus);
        Misc.init(eventBus);
        ModBlocks.init(eventBus);
        ModEntityTypes.init(eventBus);
        ModEffects.init(eventBus);
        ModPaintings.init(eventBus);
        ModPotions.init(eventBus);
        FCWorld.init(eventBus);

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

        // add Written Book to misc tab
        Utils.changeCreativeTab(Items.WRITTEN_BOOK, ItemGroup.MISC);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::enqueueIMC);

        LOG.info("Registering villager trades");
        MinecraftForge.EVENT_BUS.register(VillagerTrades.class);
        LOG.info("Setup complete");
    }

    private void setup(final FMLCommonSetupEvent event) {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation("frivycat:dimension_biomes"), FCBiomeSource.CODEC);
    }

    private void doClientStuff(final FMLClientSetupEvent event){
        ModBlocks.initClient();
        FCDimensions.initClient();
        //RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CREEPIG.get(), CreepigRenderer::new);
        //RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ILLUSIONER_LADY.get(), IllusionerLadyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIGPER.get(), PigperRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCOOBY_SKELETON.get(), ScoobySkeletonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SCOOBY_STRAY.get(), ScoobyStrayRenderer::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.CHARM.getMessageBuilder().build());
    }
}


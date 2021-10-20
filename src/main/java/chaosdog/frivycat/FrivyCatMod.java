package chaosdog.frivycat;

import chaosdog.frivycat.entities.ModEntityTypes;
import chaosdog.frivycat.world.structure.ModStructures;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("frivycat")
public class FrivyCatMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ID = "frivycat";

    public FrivyCatMod() {
        LOGGER.info("Setting up Frivy Cat mod");
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // modules
        Gems.init(eventBus);
        DummyBlocks.init(eventBus);
        Villagers.init(eventBus);
        Misc.init(eventBus);
        ModBlocks.init(eventBus);
        ModEntityTypes.init(eventBus);
        ModEffects.init(eventBus);
        ModPotions.init(eventBus);
        ModStructures.register(eventBus);

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

        LOGGER.info("Registering villager trades");
        MinecraftForge.EVENT_BUS.register(VillagerTrades.class);
        LOGGER.info("Setup complete");
    }

        private void setup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ModStructures.setupStructures();
            });
        }
    }


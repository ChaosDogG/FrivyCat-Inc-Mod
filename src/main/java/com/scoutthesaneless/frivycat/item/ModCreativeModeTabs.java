package com.scoutthesaneless.frivycat.item;

import com.scoutthesaneless.frivycat.FrivyCat;
import com.scoutthesaneless.frivycat.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FrivyCat.MOD_ID);

    public static final Supplier<CreativeModeTab> CHAOTIC_GEMS_TAB = CREATIVE_MODE_TAB.register("chaotic_gems_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.frivycat.chaotic_gems_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.SAPPHIRE);
                        output.accept(ModItems.AGATE);
                        output.accept(ModItems.JADE);
                        output.accept(ModItems.JASPER);
                        output.accept(ModItems.SPINEL);
                        output.accept(ModItems.TOPAZ);
                        output.accept(ModItems.GARNET);
                        output.accept(ModItems.ZIRCON);
                        output.accept(ModBlocks.RUBY_ORE);
                        output.accept(ModBlocks.SAPPHIRE_ORE);
                        output.accept(ModBlocks.AGATE_ORE);
                        output.accept(ModBlocks.JADE_ORE);
                        output.accept(ModBlocks.JASPER_ORE);
                        output.accept(ModBlocks.SPINEL_ORE);
                        output.accept(ModBlocks.TOPAZ_ORE);
                        output.accept(ModBlocks.GARNET_ORE);
                        output.accept(ModBlocks.ZIRCON_ORE);
                    }).build());

    public static final Supplier<CreativeModeTab> WIP = CREATIVE_MODE_TAB.register("wip",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(FrivyCat.MOD_ID, "chaotic_gems_tab"))
                    .icon(() -> new ItemStack(ModBlocks.DUMMY_A.get()))
                    .title(Component.translatable("creativetab.frivycat.wip"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.DUMMY_A);
                        output.accept(ModBlocks.DUMMY_B);
                        output.accept(ModBlocks.DUMMY_C);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

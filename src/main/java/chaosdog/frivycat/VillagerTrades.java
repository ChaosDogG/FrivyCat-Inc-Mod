package chaosdog.frivycat;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Blocks;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class VillagerTrades {
    // represents an empty slot in the trade UI
    public static final ItemStack EMPTY_SLOT = new ItemStack(Blocks.AIR);

    // adds custom trades to a villager pool (each villager get random trades depending on its profession
    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event) {
        // a basic villager trade
        BasicTrade dummy_a_level_1 = new BasicTrade(price(1), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 1, 0.1f);
        BasicTrade dummy_a_level_2 = new BasicTrade(price(2), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 6, 0.1f);
        BasicTrade dummy_a_level_3 = new BasicTrade(price(3), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 10, 0.1f);
        BasicTrade dummy_a_level_4 = new BasicTrade(price(4), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 20, 0.1f);
        BasicTrade dummy_a_level_5 = new BasicTrade(price(5), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 40, 0.1f);

        BasicTrade dummy_b_level_1 = new BasicTrade(price(1), new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), 10, 1, 0.1f);
        BasicTrade dummy_b_level_2 = new BasicTrade(price(2), new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), 10, 6, 0.1f);
        BasicTrade dummy_b_level_3 = new BasicTrade(price(3), new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), 10, 10, 0.1f);
        BasicTrade dummy_b_level_4 = new BasicTrade(price(4), new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), 10, 20, 0.1f);
        BasicTrade dummy_b_level_5 = new BasicTrade(price(5), new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), 10, 40, 0.1f);

        BasicTrade dummy_c_level_1 = new BasicTrade(price(1), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_C.get().asItem()), 10, 1, 0.1f);
        BasicTrade dummy_c_level_2 = new BasicTrade(price(2), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_C.get().asItem()), 10, 6, 0.1f);
        BasicTrade dummy_c_level_3 = new BasicTrade(price(3), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_C.get().asItem()), 10, 10, 0.1f);
        BasicTrade dummy_c_level_4 = new BasicTrade(price(4), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_C.get().asItem()), 10, 20, 0.1f);
        BasicTrade dummy_c_level_5 = new BasicTrade(price(5), new ItemStack(() -> DummyBlocks.DUMMY_B.get().asItem()), new ItemStack(() -> DummyBlocks.DUMMY_C.get().asItem()), 10, 40, 0.1f);

        // get a ruby for X emeralds
        BasicTrade ruby_trade = new BasicTrade(price(5), EMPTY_SLOT, new ItemStack(Gems.RUBY::get), 10, 1, 0.1f);
        BasicTrade sapphire_trade = new BasicTrade(price(10), EMPTY_SLOT, new ItemStack(Gems.SAPPHIRE::get), 10, 1, 0.1f);
        BasicTrade zircon_trade = new BasicTrade(price(10), EMPTY_SLOT, new ItemStack(Gems.ZIRCON::get), 10, 1, 0.1f);
        BasicTrade garnet_trade = new BasicTrade(price(45), EMPTY_SLOT, new ItemStack(Gems.GARNET::get), 10, 1, 0.1f);
        BasicTrade jade_trade = new BasicTrade(price(10), EMPTY_SLOT, new ItemStack(Gems.JADE::get), 10, 1, 0.1f);
        BasicTrade jasper_trade = new BasicTrade(price(10), EMPTY_SLOT, new ItemStack(Gems.JASPER::get), 10, 1, 0.1f);
        BasicTrade spinel_trade = new BasicTrade(price(15), EMPTY_SLOT, new ItemStack(Gems.SPINEL::get), 10, 1, 0.1f);
        BasicTrade topaz_trade = new BasicTrade(price(15), EMPTY_SLOT, new ItemStack(Gems.TOPAZ::get), 10, 1, 0.1f);
        BasicTrade agate_trade = new BasicTrade(price(5), EMPTY_SLOT, new ItemStack(Gems.AGATE::get), 10, 1, 0.1f);

        // returns a reference to the trades a villager has
        Int2ObjectMap<List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade>> trades = event.getTrades();

        // returns a villager's profession
        VillagerProfession profession = event.getType();

        // to add your trade to a villager's trade pool:
        // trades.get(<villager level as an integer, values are 1-5>).add(<name of villager trade (BasicTrade) object>);
        if (profession == Villagers.DUMMY_A.get()) {
            trades.get(1).add(dummy_a_level_1);
            trades.get(2).add(dummy_a_level_2);
            trades.get(3).add(dummy_a_level_3);
            trades.get(4).add(dummy_a_level_4);
            trades.get(5).add(dummy_a_level_5);
        }
        if (profession == Villagers.DUMMY_B.get()) {
            trades.get(1).add(dummy_b_level_1);
            trades.get(2).add(dummy_b_level_2);
            trades.get(3).add(dummy_b_level_3);
            trades.get(4).add(dummy_b_level_4);
            trades.get(5).add(dummy_b_level_5);
        }
        if (profession == Villagers.DUMMY_C.get()) {
            trades.get(1).add(dummy_c_level_1);
            trades.get(2).add(dummy_c_level_2);
            trades.get(3).add(dummy_c_level_3);
            trades.get(4).add(dummy_c_level_4);
            trades.get(5).add(dummy_c_level_5);
        }

        // these trades only occur in toolsmith villagers
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(ruby_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(sapphire_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(zircon_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(garnet_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(jade_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(jasper_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(spinel_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(topaz_trade);
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(agate_trade);
    }

    // convenience method returning an emerald ItemStack representing the price of an item
    private static ItemStack price(int numEmeralds) {
        return new ItemStack(() -> Items.EMERALD, numEmeralds);
    }
}

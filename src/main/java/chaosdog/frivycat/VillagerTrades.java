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
    public static final ItemStack EMPTY_SLOT =  new ItemStack(Blocks.AIR);

    // adds custom trades to a villager pool (each villager get random trades depending on its profession
    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event) {
        // a basic villager trade
        BasicTrade dummy_level_1 = new BasicTrade(price(1), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 1, 0.1f);
        BasicTrade dummy_level_2 = new BasicTrade(price(2), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 1, 0.1f);
        BasicTrade dummy_level_3 = new BasicTrade(price(3), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 1, 0.1f);
        BasicTrade dummy_level_4 = new BasicTrade(price(4), EMPTY_SLOT, new ItemStack(() -> DummyBlocks.DUMMY_A.get().asItem()), 10, 1, 0.1f);

        // get a ruby for 45 emeralds
        BasicTrade ruby_trade = new BasicTrade(price(45), EMPTY_SLOT, new ItemStack(Gems.RUBY::get), 10, 1, 0.1f);

        // returns a reference to the trades a villager has
        Int2ObjectMap<List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade>> trades = event.getTrades();

        // returns a villager's profession
        VillagerProfession profession = event.getType();

        // to add your trade to a villager's trade pool:
        // trades.get(<villager level as an integer, values are 1-5>).add(<name of villager trade (BasicTrade) object>);
        trades.get(1).add(dummy_level_1);
        trades.get(2).add(dummy_level_2);
        trades.get(3).add(dummy_level_3);
        trades.get(4).add(dummy_level_4);

        // this trade only occurs in tool smith villagers
        if (profession == VillagerProfession.TOOLSMITH) trades.get(1).add(ruby_trade);

        System.out.println(profession);
    }

    // convenience method returning an emerald ItemStack representing the price of an item
    private static ItemStack price(int numEmeralds) {
        return new ItemStack(() -> Items.EMERALD, numEmeralds);
    }
}

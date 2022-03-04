package chaosdog.frivycat.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ShinyItem extends Item {
    public ShinyItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    public boolean isPiglinCurrency(ItemStack stack) {
        return true;
    }
}

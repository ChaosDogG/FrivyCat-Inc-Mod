package com.chaosdog.frivycat.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// custom class for items that need to be shiny (in as having the enchanted glint effect)
// it is constructed the same way as regular items
public class ShinyItem extends Item {
    public ShinyItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

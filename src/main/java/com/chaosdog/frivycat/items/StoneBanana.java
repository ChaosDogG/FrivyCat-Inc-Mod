package com.chaosdog.frivycat.items;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;

import java.util.Set;

// this will be the class that will represent the stone banana
public class StoneBanana extends ToolItem {
    public StoneBanana(float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn, Item.Properties properties) {
        super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, properties);
    }
}

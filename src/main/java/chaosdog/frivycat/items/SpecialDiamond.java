package chaosdog.frivycat.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class SpecialDiamond extends Item implements ICurioItem {
    private final boolean isShiny;

    public SpecialDiamond(boolean isShiny) {
        super(new Item.Properties().group(ModItemGroup.WIP).rarity(Rarity.EPIC));
        this.isShiny = isShiny;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return isShiny;
    }
}

package chaosdog.frivycat.items;

import chaosdog.frivycat.Misc;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup WIP = new ItemGroup("wipTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Misc.PENCIL.get());
        }
    };
}

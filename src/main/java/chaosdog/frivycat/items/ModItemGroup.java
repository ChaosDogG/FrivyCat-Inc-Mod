package chaosdog.frivycat.items;

import chaosdog.frivycat.Misc;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {

    public static final CreativeModeTab WIP = new CreativeModeTab("wipTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Misc.PENCIL.get());
        }
    };
}

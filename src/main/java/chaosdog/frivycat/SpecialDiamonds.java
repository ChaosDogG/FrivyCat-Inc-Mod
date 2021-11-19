package chaosdog.frivycat;

import chaosdog.frivycat.items.ShinyItem;
import chaosdog.frivycat.items.SpecialDiamond;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialDiamonds {
    // registries (they don't need to be public)
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // special diamonds
    public static final RegistryObject<Item> DARK_DIAMOND = regSpecialDiamond("dark", true);
    public static final RegistryObject<Item> SHADOW_DIAMOND = regSpecialDiamond("shadow", true);
    public static final RegistryObject<Item> CULTIST_DIAMOND = regSpecialDiamond("cultist", true);
    public static final RegistryObject<Item> FIRE_DIAMOND = regSpecialDiamond("fire", true);
    public static final RegistryObject<Item> LIGHTNING_DIAMOND = regSpecialDiamond("lightning", true);
    public static final RegistryObject<Item> PEACE_DIAMOND = regSpecialDiamond("peace", true);
    public static final RegistryObject<Item> VINE_DIAMOND = regSpecialDiamond("vine", true);
    public static final RegistryObject<Item> VETERAN_DIAMOND = regSpecialDiamond("veteran", true);
    public static final RegistryObject<Item> HOLY_DIAMOND = regSpecialDiamond("holy", true);
    public static final RegistryObject<Item> WATER_DIAMOND = regSpecialDiamond("water", true);
    public static final RegistryObject<Item> MADNESS_DIAMOND = regSpecialDiamond("madness", true);
    public static final RegistryObject<Item> CORRUPTED_DIAMOND = regSpecialDiamond("corrupted", true);
    public static final RegistryObject<Item> CATALYST_DIAMOND = regSpecialDiamond("catalyst", false);
    public static final RegistryObject<Item> DRAINED_DIAMOND = regSpecialDiamond("drained", false);

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOG.info("Setting up Special Diamonds");
        // register the registries
        ITEMS.register(eventbus);
    }

    // registers a special diamond item
    private static RegistryObject<Item> regSpecialDiamond(String name, boolean isShiny) {
        return Utils.regItem(ITEMS, name + "_diamond", new SpecialDiamond(isShiny));
    }
}

package chaosdog.frivycat;

import chaosdog.frivycat.items.ShinyItem;
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
    public static final RegistryObject<Item> DARK_DIAMOND = regSpecialDiamond("dark");
    public static final RegistryObject<Item> SHADOW_DIAMOND = regSpecialDiamond("shadow");
    public static final RegistryObject<Item> CULTIST_DIAMOND = regSpecialDiamond("cultist");
    public static final RegistryObject<Item> FIRE_DIAMOND = regSpecialDiamond("fire");
    public static final RegistryObject<Item> LIGHTNING_DIAMOND = regSpecialDiamond("lightning");
    public static final RegistryObject<Item> PEACE_DIAMOND = regSpecialDiamond("peace");
    public static final RegistryObject<Item> VINE_DIAMOND = regSpecialDiamond("vine");
    public static final RegistryObject<Item> VETERAN_DIAMOND = regSpecialDiamond("veteran");
    public static final RegistryObject<Item> HOLY_DIAMOND = regSpecialDiamond("holy");
    public static final RegistryObject<Item> WATER_DIAMOND = regSpecialDiamond("water");
    public static final RegistryObject<Item> MADNESS_DIAMOND = regSpecialDiamond("madness");
    public static final RegistryObject<Item> CORRUPTED_DIAMOND = regSpecialDiamond("corrupted");
    public static final RegistryObject<Item> CATALYST_DIAMOND = regSpecialDiamond("catalyst");
    public static final RegistryObject<Item> DRAINED_DIAMOND = regSpecialDiamond("drained");

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOG.info("Setting up Special Diamonds");
        // register the registries
        ITEMS.register(eventbus);
    }

    // registers a special diamond item
    private static RegistryObject<Item> regSpecialDiamond(String name) {
        return Utils.regItem(ITEMS, name + "_diamond", new ShinyItem(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.EPIC)));
    }
}

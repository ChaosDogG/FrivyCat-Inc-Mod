package chaosdog.frivycat.world.structure.dimension;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.Utils;
import chaosdog.frivycat.blocks.FCPortalBlock;
import chaosdog.frivycat.items.ModItemGroup;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FCDimensions {
    private static final DeferredRegister<Block> PORTALS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> PORTAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    public static final FCPortalBlock SPIRIT_REALM_PORTAL = new FCPortalBlock(FCDimensionType.SPIRIT_REALM);
    public static final FCPortalBlock WOODED_TERRORS_PORTAL = new FCPortalBlock(FCDimensionType.WOODED_TERRORS);
    public static final FCPortalBlock PASSIVE_FIELDS_PORTAL = new FCPortalBlock(FCDimensionType.PASSIVE_FIELDS);

    // point of interest types for the portals
    private static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, FrivyCatMod.ID);

    public static final RegistryObject<PointOfInterestType> SPIRIT_REALM_POI = POI_TYPES.register("spirit_realm_poi", () -> new PointOfInterestType("spirit_realm_poi", ImmutableSet.of(SPIRIT_REALM_PORTAL.getDefaultState()), 0, 1));
    public static final RegistryObject<PointOfInterestType> WOODED_TERRORS_POI = POI_TYPES.register("wooded_terrors_poi", () -> new PointOfInterestType("wooded_terrors_poi", ImmutableSet.of(WOODED_TERRORS_PORTAL.getDefaultState()), 0, 1));
    public static final RegistryObject<PointOfInterestType> PASSIVE_FIELDS_POI = POI_TYPES.register("passive_fields_poi", () -> new PointOfInterestType("passive_fields_poi", ImmutableSet.of(PASSIVE_FIELDS_PORTAL.getDefaultState()), 0, 1));

    public static void init(IEventBus eventbus) {
        PORTALS.register(eventbus);
        PORTAL_ITEMS.register(eventbus);
        POI_TYPES.register(eventbus);

        Utils.regBlockWithItem(PORTALS, PORTAL_ITEMS, "passive_fields_portal", PASSIVE_FIELDS_PORTAL, ModItemGroup.WIP);
        Utils.regBlockWithItem(PORTALS, PORTAL_ITEMS, "wooded_terrors_portal", WOODED_TERRORS_PORTAL, ModItemGroup.WIP);
        Utils.regBlockWithItem(PORTALS, PORTAL_ITEMS, "spirit_realm_portal", SPIRIT_REALM_PORTAL, ModItemGroup.WIP);
    }

    public static void initClient() {
        RenderTypeLookup.setRenderLayer(SPIRIT_REALM_PORTAL, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PASSIVE_FIELDS_PORTAL, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WOODED_TERRORS_PORTAL, RenderType.getTranslucent());
    }
}

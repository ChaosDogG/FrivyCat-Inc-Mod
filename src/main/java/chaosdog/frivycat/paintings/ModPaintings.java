package chaosdog.frivycat.paintings;

import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPaintings {
    public static final DeferredRegister<PaintingType> PAINTING_TYPES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, FrivyCatMod.ID);

    public static final RegistryObject<PaintingType> CHAOS =
            PAINTING_TYPES.register("chaos", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> NOAH =
            PAINTING_TYPES.register("noah", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> GAMINGJESS =
            PAINTING_TYPES.register("gamingjess", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> DEMONITIZED =
            PAINTING_TYPES.register("demonitized", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> RAVEN =
            PAINTING_TYPES.register("raven", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> PEANUT_BUTTER_JELLY_TIME =
            PAINTING_TYPES.register("peanut_butter_jelly_time", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> DOGE_INTENSIFIES =
            PAINTING_TYPES.register("doge_intensifies", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> WALUIGI_LOGO =
            PAINTING_TYPES.register("waluigi_logo", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> FLINT =
            PAINTING_TYPES.register("flint", () -> new PaintingType(16, 16));
    public static final RegistryObject<PaintingType> KIT =
            PAINTING_TYPES.register("kit", () -> new PaintingType(16, 16));

    public static final RegistryObject<PaintingType> MUMBO =
            PAINTING_TYPES.register("mumbo", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> LOGDOTZIP =
            PAINTING_TYPES.register("logdotzip", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> GRIAN =
            PAINTING_TYPES.register("grian", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> MRCRAYFISH =
            PAINTING_TYPES.register("mrcrayfish", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> DONIBOBES =
            PAINTING_TYPES.register("donibobes", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> SB737 =
            PAINTING_TYPES.register("sb737", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> SOCKS =
            PAINTING_TYPES.register("socks", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> LAFF =
            PAINTING_TYPES.register("laff", () -> new PaintingType(32, 32));
    public static final RegistryObject<PaintingType> TBH =
            PAINTING_TYPES.register("tbh", () -> new PaintingType(32, 32));

    public static final RegistryObject<PaintingType> CHAOS_SPIRITS =
            PAINTING_TYPES.register("chaos_spirits", () -> new PaintingType(64, 48));

    public static final RegistryObject<PaintingType> LEGACY_LOGO =
            PAINTING_TYPES.register("legacy_logo", () -> new PaintingType(64, 64));
    public static final RegistryObject<PaintingType> FRIVY =
            PAINTING_TYPES.register("frivy", () -> new PaintingType(64, 64));
    public static final RegistryObject<PaintingType> WALUIGI =
            PAINTING_TYPES.register("waluigi", () -> new PaintingType(64, 64));

    public static void init(IEventBus eventBus){
        FrivyCatMod.LOG.info("Setting up paintings");
        PAINTING_TYPES.register(eventBus);
    }
}

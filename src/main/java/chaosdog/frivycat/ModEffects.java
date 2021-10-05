package chaosdog.frivycat;

import chaosdog.frivycat.effects.ModEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    private static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, FrivyCatMod.ID);

    public static final RegistryObject<ModEffect> SLIPPERY = Utils.regEffect(EFFECTS, "slippery", new ModEffect(EffectType.HARMFUL, 0xf7f4b6));
    //public static final RegistryObject<ModEffect> CREATIVE_LIKE = Utils.regEffect(EFFECTS, "creative_like", new ModEffect(EffectType.BENEFICIAL, 0x19a6f5));

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOGGER.info("Setting up Effects");
        //register the registry
        EFFECTS.register(eventBus);
    }
}

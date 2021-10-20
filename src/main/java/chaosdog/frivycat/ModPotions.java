package chaosdog.frivycat;

import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, FrivyCatMod.ID);

    //public static final RegistryObject<Potion> SLIPPERY = Utils.regPotion(POTIONS, "slippery", new Potion(new EffectInstance(ModEffects.SLIPPERY.get(), 3600)));
    //public static final RegistryObject<Potion> LONG_SLIPPERY = Utils.regPotion(POTIONS, "long_slippery", new Potion(new EffectInstance(ModEffects.SLIPPERY.get(), 9600)));


    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOG.info("Setting up Potions");
        //register the registry
        POTIONS.register(eventBus);
    }
}

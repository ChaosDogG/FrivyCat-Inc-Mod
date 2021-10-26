package chaosdog.frivycat.events;

import chaosdog.frivycat.FrivyCatMod;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrivyCatMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    /*@SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.PIGPER.get(), PigperEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }*/
}

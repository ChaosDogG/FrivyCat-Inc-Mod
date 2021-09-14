package chaosdog.frivycat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Entities<T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>> {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FrivyCatMod.ID);

    //public static final RegistryObject<EntityType<EasterEgg>> EASTER_EGG = Utils.regEntity(ENTITIES, "easter_egg", EntityType.Builder<EasterEgg>create(EasterEgg::new, EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(10));

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOGGER.info("Setting up the entities");
        // register the entity registry object
        ENTITIES.register(eventBus);
    }
}

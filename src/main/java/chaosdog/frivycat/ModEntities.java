package chaosdog.frivycat;

import chaosdog.frivycat.entities.projectile.EasterEggProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities<T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>> {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FrivyCatMod.ID);

    public static final RegistryObject<EntityType<Entity>> EASTER_EGG_PROJECTILE = ENTITY_TYPES.register("easter_egg",
            () -> EntityType.Builder.create(EasterEggProjectile::new, EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(FrivyCatMod.ID, "easter_egg").toString()));

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOGGER.info("Setting up the entities");
        // register the entity registry object
        ENTITY_TYPES.register(eventBus);
    }
}

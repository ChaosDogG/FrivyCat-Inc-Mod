package chaosdog.frivycat.entities;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.entities.hostile.ScoobySkeletonEntity;
import chaosdog.frivycat.entities.hostile.ScoobyStrayEntity;
import chaosdog.frivycat.entities.passive.PigperEntity;
import chaosdog.frivycat.entities.projectile.EasterEggProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FrivyCatMod.ID);

    public static final RegistryObject<EntityType<Entity>> EASTER_EGG_PROJECTILE =
            ENTITY_TYPES.register("easter_egg",
                    () -> EntityType.Builder.create(EasterEggProjectile::new,
                            EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "easter_egg").toString()));

    public static final RegistryObject<EntityType<ScoobySkeletonEntity>> SCOOBY_SKELETON =
            ENTITY_TYPES.register("scooby-skeleton",
                    () -> EntityType.Builder.create(ScoobySkeletonEntity::new,
                            EntityClassification.MONSTER).size(1.0f,2.0f).trackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "scooby_skeleton").toString()));

    public static final RegistryObject<EntityType<ScoobyStrayEntity>> SCOOBY_STRAY =
            ENTITY_TYPES.register("scooby-stray",
                    () -> EntityType.Builder.create(ScoobyStrayEntity::new,
                                    EntityClassification.MONSTER).size(1.0f,2.0f).trackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "scooby_stray").toString()));
    public static final RegistryObject<EntityType<PigperEntity>> PIGPER =
            ENTITY_TYPES.register("pig-per",
                    () -> EntityType.Builder.create(PigperEntity::new,
                            EntityClassification.CREATURE).size(0.9f, 0.9f).trackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "pig-per").toString()));
    /*public static final RegistryObject<EntityType<CreepigEntity>> CREEPIG =
            ENTITY_TYPES.register("cree-pig",
                    () -> EntityType.Builder.create(CreepigEntity::new,
                            EntityClassification.MONSTER).size(1.0f, 2.0f).trackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "cree-pig").toString()));*/

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOG.info("Setting up the entities");
        // register the entity registry object
        ENTITY_TYPES.register(eventBus);
    }
}

package chaosdog.frivycat.entities;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.entities.hostile.ScoobySkeletonEntity;
import chaosdog.frivycat.entities.hostile.ScoobyStrayEntity;
import chaosdog.frivycat.entities.passive.PigperEntity;
import chaosdog.frivycat.entities.projectile.EasterEggProjectile;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FrivyCatMod.ID);

    public static final RegistryObject<EntityType<EasterEggProjectile>> EASTER_EGG_PROJECTILE =
            ENTITY_TYPES.register("easter_egg",
                    () -> EntityType.Builder.<EasterEggProjectile>of(EasterEggProjectile::new,
                            MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "easter_egg").toString()));

    /*public static final RegistryObject<EntityType<IllusionerLadyEntity>> ILLUSIONER_LADY =
            ENTITY_TYPES.register("illusioner_lady",
                    () -> EntityType.Builder.create(IllusionerLadyEntity::new,
                                    MobCategory.MONSTER).sized(1.0f,2.0f).clientTrackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "illusioner_lady").toString()));*/

    public static final RegistryObject<EntityType<ScoobySkeletonEntity>> SCOOBY_SKELETON =
            ENTITY_TYPES.register("scooby-skeleton",
                    () -> EntityType.Builder.<ScoobySkeletonEntity>of(ScoobySkeletonEntity::new,
                                    MobCategory.MONSTER).sized(1.0f,2.0f).clientTrackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "scooby_skeleton").toString()));

    public static final RegistryObject<EntityType<ScoobyStrayEntity>> SCOOBY_STRAY =
            ENTITY_TYPES.register("scooby-stray",
                    () -> EntityType.Builder.<ScoobyStrayEntity>of(ScoobyStrayEntity::new,
                                    MobCategory.MONSTER).sized(1.0f,2.0f).clientTrackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "scooby_stray").toString()));
    public static final RegistryObject<EntityType<PigperEntity>> PIGPER =
            ENTITY_TYPES.register("pig-per",
                    () -> EntityType.Builder.<PigperEntity>of(PigperEntity::new,
                                    MobCategory.CREATURE).sized(0.9f, 0.9f).clientTrackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "pig-per").toString()));
    /*public static final RegistryObject<EntityType<CreepigEntity>> CREEPIG =
            ENTITY_TYPES.register("cree-pig",
                    () -> EntityType.Builder.create(CreepigEntity::new,
                            MobCategory.MONSTER).sized(1.0f, 2.0f).clientTrackingRange(10)
                            .build(new ResourceLocation(FrivyCatMod.ID, "cree-pig").toString()));*/

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOG.info("Setting up the entities");
        // register the entity registry object
        ENTITY_TYPES.register(eventBus);
    }
}

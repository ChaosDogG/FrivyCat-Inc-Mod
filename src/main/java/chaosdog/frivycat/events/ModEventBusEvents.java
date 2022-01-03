package chaosdog.frivycat.events;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.entities.ModEntityTypes;
import chaosdog.frivycat.entities.hostile.ScoobySkeletonEntity;
import chaosdog.frivycat.entities.hostile.ScoobyStrayEntity;
import chaosdog.frivycat.entities.passive.PigperEntity;
import chaosdog.frivycat.events.loot.LuckyBlocksInStructures;
import chaosdog.frivycat.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FrivyCatMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        //event.put(ModEntityTypes.CREEPIG.get(), CreepigEntity.setCustomAttributes().create());
        //event.put(ModEntityTypes.ILLUSIONER_LADY.get(), IllusionerLadyEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.PIGPER.get(), PigperEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.SCOOBY_SKELETON.get(), ScoobySkeletonEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.SCOOBY_STRAY.get(), ScoobyStrayEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                   event){
        event.getRegistry().registerAll(
                new LuckyBlocksInStructures.Serializer().setRegistryName
                        (new ResourceLocation(FrivyCatMod.ID, "lucky_blocks_in_structures"))
        );
    }
}

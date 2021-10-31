package chaosdog.frivycat.mixin;

import chaosdog.frivycat.world.WorldSeed;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

// this gets the seed created by Minecraft when a dimension is first created
@Mixin(DimensionGeneratorSettings.class)
public abstract class DimensionGeneratorSettingsMixin {
    @Inject(method = "<init>(JZZLnet/minecraft/util/registry/SimpleRegistry;Ljava/util/Optional;)V", at = @At(value = "RETURN"))
    private void getSeedFromConstructor(long seed, boolean generateFeatures, boolean bonusChest, SimpleRegistry<Dimension> options, Optional<String> legacyOptions, CallbackInfo ci) {
        WorldSeed.setSeed(seed);
    }
}

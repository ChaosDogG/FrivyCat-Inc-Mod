package chaosdog.frivycat.mixin;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.world.WorldSeed;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

// this sets the seed of a JSON dimension to the world seed if the seed specified in the file is -1
// Paradise Mod will handle this if it is loaded
@Mixin(NoiseChunkGenerator.class)
public abstract class NoiseChunkGeneratorMixin {
    @Shadow
    private long field_236084_w_;

    @Inject(method = "<init>(Lnet/minecraft/world/biome/provider/BiomeProvider;Lnet/minecraft/world/biome/provider/BiomeProvider;JLjava/util/function/Supplier;)V", at = @At(value = "RETURN"))
    private void setSeedToWorld(BiomeProvider provider1, BiomeProvider provider2, long seed, Supplier<DimensionSettings> settings, CallbackInfo ci) {
        if (!ModList.get().isLoaded("paradisemod")) {
            long worldSeed = WorldSeed.getSeed();
            FrivyCatMod.LOG.debug("This world's seed: " + worldSeed);
            FrivyCatMod.LOG.debug("This chunk generator's seed:" + seed);
            if (worldSeed != -1L && seed == -1L) field_236084_w_ = worldSeed;
        }
    }
}

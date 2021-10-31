package chaosdog.frivycat.mixin;

import chaosdog.frivycat.FrivyCatMod;
import com.mojang.serialization.Lifecycle;
import net.minecraft.world.storage.ServerWorldInfo;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Paradise Mod will handle this if it is loaded
@Mixin(ServerWorldInfo.class)
public abstract class ServerWorldInfoMixin {
    @Inject(method = "getLifecycle", at = @At("HEAD"), cancellable = true)
    private void noExperimentalWarning(CallbackInfoReturnable<Lifecycle> lifecycle) {
        if (!ModList.get().isLoaded("paradisemod")) {
            lifecycle.setReturnValue(Lifecycle.stable());
            FrivyCatMod.LOG.debug("NetherNoah777: Dear Mojang, if we are using mods, we are already aware that experimental world settings are unsupported because mods are unsupported by you guys as well!");
        }
    }
}

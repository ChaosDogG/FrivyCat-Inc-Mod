package chaosdog.frivycat.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class CreativeLikeEffect extends Effect {
    public CreativeLikeEffect(EffectType type, int liquidColor) {
        super(type, liquidColor);
    }

    public void performEffect(LivingEntity living, int amplifier){
        if(living instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) living;
            player.abilities.allowFlying = true;
            player.abilities.isCreativeMode = true;
            player.abilities.disableDamage = true;
        }
    }

    @Override
    public boolean isReady(int p_76397_1_, int p_76397_2_) {
        return true;
    }
}

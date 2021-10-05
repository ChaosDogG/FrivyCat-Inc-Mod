package chaosdog.frivycat.items;

import chaosdog.frivycat.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;

public class Butter extends Item {
    public Butter(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if(entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            living.attackEntityFrom(DamageSource.GENERIC, 0.0f);
            living.addPotionEffect(new EffectInstance(ModEffects.SLIPPERY.get(), 200, 1));
        }
        if(!player.isCreative()) {
            stack.shrink(1);
        }
        return true;
    }
}

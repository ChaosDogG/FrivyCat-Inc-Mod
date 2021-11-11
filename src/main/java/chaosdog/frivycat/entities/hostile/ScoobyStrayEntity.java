package chaosdog.frivycat.entities.hostile;

import chaosdog.frivycat.ModEffects;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import java.util.Random;

public class ScoobyStrayEntity extends AbstractSkeletonEntity {

    public ScoobyStrayEntity(EntityType<? extends ScoobyStrayEntity> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, CreeperEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, StrayEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WanderingTraderEntity.class, true));
        super.registerGoals();
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
    }

    public static boolean func_223327_b(EntityType<ScoobyStrayEntity> p_223327_0_, IServerWorld p_223327_1_, SpawnReason reason, BlockPos p_223327_3_, Random p_223327_4_) {
        return canMonsterSpawnInLight(p_223327_0_, p_223327_1_, reason, p_223327_3_, p_223327_4_) && (reason == SpawnReason.SPAWNER || p_223327_1_.canSeeSky(p_223327_3_));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_STRAY_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_STRAY_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_STRAY_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_STRAY_STEP;
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (!super.attackEntityAsMob(entityIn)) {
            return false;
        } else {
            if (entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.SPEED, 200));
            }

            return true;
        }
    }

    /**
     * Fires an arrow
     */
    protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
        AbstractArrowEntity abstractarrowentity = super.fireArrow(arrowStack, distanceFactor);
        if (abstractarrowentity instanceof ArrowEntity) {
            ((ArrowEntity)abstractarrowentity).addEffect(new EffectInstance(ModEffects.SLIPPERY.get(), 600));
            ((ArrowEntity)abstractarrowentity).addEffect(new EffectInstance(Effects.LUCK, 600));
        }

        return abstractarrowentity;
    }
}

package chaosdog.frivycat.entities.hostile;

import chaosdog.frivycat.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.entity.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;

import java.util.Random;

public class ScoobyStrayEntity extends AbstractSkeleton {

    public ScoobyStrayEntity(EntityType<? extends ScoobyStrayEntity> type, Level world) {
        super(type, world);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Stray.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, TraderLlama.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WanderingTrader.class, true));
        super.registerGoals();
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    public static boolean func_223327_b(EntityType<ScoobyStrayEntity> p_223327_0_, ServerLevelAccessor p_223327_1_, MobSpawnType reason, BlockPos p_223327_3_, Random p_223327_4_) {
        BlockPos blockpos = p_223327_3_;

        do {
            blockpos = blockpos.above();
        } while(p_223327_1_.getBlockState(blockpos).is(Blocks.POWDER_SNOW));

        return checkMonsterSpawnRules(p_223327_0_, p_223327_1_, reason, p_223327_3_, p_223327_4_) && (reason == MobSpawnType.SPAWNER || p_223327_1_.canSeeSky(p_223327_3_));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.STRAY_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.STRAY_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.STRAY_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.STRAY_STEP;
    }

    public boolean doHurtTarget(Entity entityIn) {
        if (!super.doHurtTarget(entityIn)) {
            return false;
        } else {
            if (entityIn instanceof LivingEntity) {
                Object Effects = null;
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200));
            }

            return true;
        }
    }

    /**
     * Fires an arrow
     */
    protected AbstractArrow getArrow(ItemStack arrowStack, float distanceFactor) {
        AbstractArrow abstractarrowentity = super.getArrow(arrowStack, distanceFactor);
        if (abstractarrowentity instanceof Arrow) {
            ((Arrow)abstractarrowentity).addEffect(new MobEffectInstance(ModEffects.SLIPPERY.get(), 600));
            ((Arrow)abstractarrowentity).addEffect(new MobEffectInstance(MobEffects.UNLUCK, 600));
        }

        return abstractarrowentity;
    }
}

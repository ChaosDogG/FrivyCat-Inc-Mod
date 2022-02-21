package chaosdog.frivycat.blocks;

import net.minecraft.block.RedstoneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.passive.horse.TraderLlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

import java.util.UUID;

import net.minecraft.block.AbstractBlock.Properties;

public class MumboBlock extends RedstoneBlock {
    public MumboBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof WanderingTraderEntity || entityIn instanceof TraderLlamaEntity) {
            LivingEntity living = (LivingEntity) entityIn;
            living.attackEntityFrom(DamageSource.MAGIC, Float.MAX_VALUE);
        }
        if(entityIn instanceof PlayerEntity) {
            PlayerEntity mumbo = (PlayerEntity) entityIn;
            if(mumbo.getUniqueID().equals(UUID.fromString("c7da90d5-6a05-4217-b94a-7d427cbbcad8"))) {
                if (mumbo.isSwingInProgress) {
                    if (mumbo.experienceLevel >= 3 && !mumbo.isPotionActive(Effects.BLINDNESS)) {
                        if (!mumbo.isCreative()) {
                            mumbo.setGameType(GameType.CREATIVE);
                        } else {
                            mumbo.setGameType(GameType.SURVIVAL);
                        }
                        mumbo.addExperienceLevel(-3);
                        mumbo.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200));
                    }
                }
            }
        }
    }
}

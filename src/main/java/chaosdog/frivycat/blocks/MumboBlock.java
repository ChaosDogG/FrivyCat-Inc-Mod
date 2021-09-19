package chaosdog.frivycat.blocks;

import net.minecraft.block.RedstoneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.passive.horse.TraderLlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class MumboBlock extends RedstoneBlock {
    public MumboBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof WanderingTraderEntity || entityIn instanceof TraderLlamaEntity) {
            LivingEntity living = (LivingEntity) entityIn;
            living.attackEntityFrom(DamageSource.MAGIC, 1000);
        }
        if(entityIn instanceof PlayerEntity) {
            PlayerEntity mumbo = (PlayerEntity) entityIn;
            if(mumbo.getUniqueID().equals("c7da90d5-6a05-4217-b94a-7d427cbbcad8")) {
            if(mumbo.isSwingInProgress) {
                mumbo.setGameType(GameType.CREATIVE);
            }
            if(mumbo.isSprinting()) {
                mumbo.setGameType(GameType.SURVIVAL);
            }
            }
        }
    }


}

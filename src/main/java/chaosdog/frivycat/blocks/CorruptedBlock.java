package chaosdog.frivycat.blocks;

import chaosdog.frivycat.SpecialDiamonds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.WorldData;
import net.minecraft.world.phys.Vec3;

public class CorruptedBlock extends Block {
    public CorruptedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityCollision(BlockState state, WorldData worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entityIn;
            if(entityIn instanceof Player) {
                Player player = (Player) entityIn;
                if(player.isAlive() && !(player.getMainHandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get() || player.getOffhandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get())) {
                    if(!worldIn.getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
                        player.inventory.dropAll();
                    }
                    player.displayClientMessage(new TranslatableComponent("message.corrupted_block_collide_unsafe").withStyle(ChatFormatting.DARK_RED), true);
                    player.experienceProgress = this.RANDOM.nextFloat();
                    player.experienceLevel = this.RANDOM.nextInt(101);
                }
                if(player.getMainHandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get() || player.getOffhandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get()) {
                    player.displayClientMessage(new TranslatableComponent("message.corrupted_block_collide_safe").withStyle(ChatFormatting.DARK_PURPLE), true);
                }
            }
            if(!(living.getTags().contains("corrupted") || living.getMainHandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get() || living.getOffhandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get() || entityIn instanceof Squid)) {
                living.setHealth(0);
            }
            if(living.getMainHandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get() || living.getOffhandItem().getItem() == SpecialDiamonds.CORRUPTED_DIAMOND.get()) {
                living.addEffect(new MobEffectInstance(MobEffects.LUCK, 4000, 50));
                living.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 4000, 3));
            }
        }
        if(entityIn instanceof ItemEntity) {
            ItemEntity item = (ItemEntity) entityIn;
            item.setNeverPickUp();
        }
        entityIn.setMotionMultiplier(state, new Vec3(2.0D, 2.0F, 2.0D));
    }

}

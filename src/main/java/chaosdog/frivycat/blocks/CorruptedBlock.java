package chaosdog.frivycat.blocks;

import chaosdog.frivycat.Gems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CorruptedBlock extends Block {
    public CorruptedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entityIn;
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entityIn;
                if(player.isAlive() && !(player.getHeldItemMainhand().getItem() == Gems.CORRUPTED_DIAMOND.get())) {
                    player.sendStatusMessage(new TranslationTextComponent("message.corrupted_block_collide_unsafe").mergeStyle(TextFormatting.DARK_RED), true);
                }
                if(player.getHeldItemMainhand().getItem() == Gems.CORRUPTED_DIAMOND.get()) {
                    player.sendStatusMessage(new TranslationTextComponent("message.corrupted_block_collide_safe").mergeStyle(TextFormatting.DARK_PURPLE), true);
                }
            }
            if(!(living.getTags().contains("corrupted")) && !(living.getHeldItemMainhand().getItem() == Gems.CORRUPTED_DIAMOND.get()) && !(entityIn instanceof SquidEntity))
            living.setHealth(0);
            if(living.getHeldItemMainhand().getItem() == Gems.CORRUPTED_DIAMOND.get()) {
                living.addPotionEffect(new EffectInstance(Effects.LUCK, 4000, 50));
                living.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 4000, 3));
            }
        }
        if(entityIn instanceof ItemEntity) {
            ItemEntity item = (ItemEntity) entityIn;
            item.setInfinitePickupDelay();
        }
        entityIn.setMotionMultiplier(state, new Vector3d(2.0D, 2.0F, 2.0D));
    }

}

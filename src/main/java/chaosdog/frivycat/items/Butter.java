package chaosdog.frivycat.items;

import chaosdog.frivycat.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public class Butter extends Item {
    public Butter(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity living, InteractionHand hand) {
        living.addEffect(new MobEffectInstance(ModEffects.SLIPPERY.get(), 200, 1));
        if(!player.isCreative()) {
            stack.shrink(1);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult onItemUse(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos block = context.getClickedPos();
        BlockState clicked = world.getBlockState(block);
        if (clicked.is(Blocks.END_PORTAL_FRAME) && clicked.getValue(EndPortalFrameBlock.HAS_EYE)) {
            if(world.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState clicked1 = clicked.setValue(EndPortalFrameBlock.HAS_EYE, Boolean.FALSE);
                Player playerIn = Objects.requireNonNull(context.getPlayer());
                world.setBlock(block, clicked1, 2);
                world.updateNeighbourForOutputSignal(block, Blocks.END_PORTAL_FRAME);
                double d0 = (double)(world.random.nextFloat() * 0.7F) + (double)0.15F;
                double d1 = (double)(world.random.nextFloat() * 0.7F) + (double)0.060000002F + 0.6D;
                double d2 = (double)(world.random.nextFloat() * 0.7F) + (double)0.15F;
                ItemEntity itementity = new ItemEntity(world, (double)block.getX() + d0, (double)block.getY() + d1, (double)block.getZ() + d2, new ItemStack(Items.ENDER_EYE));
                itementity.setDefaultPickUpDelay();
                world.addFreshEntity(itementity);
                context.getItemInHand().shrink(1);
                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
}

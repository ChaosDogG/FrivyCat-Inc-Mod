package chaosdog.frivycat.items;

import chaosdog.frivycat.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class Butter extends Item {
    public Butter(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity living, Hand hand) {
        living.addPotionEffect(new EffectInstance(ModEffects.SLIPPERY.get(), 200, 1));
        if(!player.isCreative()) {
            stack.shrink(1);
            return ActionResultType.CONSUME;
        }
        return ActionResultType.PASS;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos block = context.getPos();
        BlockState clicked = world.getBlockState(block);
        if (clicked.matchesBlock(Blocks.END_PORTAL_FRAME) && clicked.get(EndPortalFrameBlock.EYE)) {
            if(world.isRemote) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState clicked1 = clicked.with(EndPortalFrameBlock.EYE, Boolean.FALSE);
                PlayerEntity playerIn = Objects.requireNonNull(context.getPlayer());
                world.setBlockState(block, clicked1, 2);
                world.updateComparatorOutputLevel(block, Blocks.END_PORTAL_FRAME);
                double d0 = (double)(world.rand.nextFloat() * 0.7F) + (double)0.15F;
                double d1 = (double)(world.rand.nextFloat() * 0.7F) + (double)0.060000002F + 0.6D;
                double d2 = (double)(world.rand.nextFloat() * 0.7F) + (double)0.15F;
                ItemEntity itementity = new ItemEntity(world, (double)block.getX() + d0, (double)block.getY() + d1, (double)block.getZ() + d2, new ItemStack(Items.ENDER_EYE));
                itementity.setDefaultPickupDelay();
                world.addEntity(itementity);
                context.getItem().shrink(1);
                return ActionResultType.CONSUME;
            }
        } else {
            return ActionResultType.PASS;
        }
    }
}

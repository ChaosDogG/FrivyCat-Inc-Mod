package chaosdog.frivycat.items;

import chaosdog.frivycat.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
                world.setBlockState(block, clicked1, 2);
                world.updateComparatorOutputLevel(block, Blocks.END_PORTAL_FRAME);
                context.getItem().shrink(1);
                return ActionResultType.CONSUME;
            }
        } else {
            return ActionResultType.PASS;
        }
    }
}

package chaosdog.frivycat.items;

import chaosdog.frivycat.Misc;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class Mug extends BottleItem {
    public Mug(Properties builder) {
        super(builder);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        List<AreaEffectCloud> list = worldIn.getEntitiesOfClass(AreaEffectCloud.class, playerIn.getBoundingBox().inflate(2.0D), (cloud) -> {
            return cloud != null && cloud.isAlive() && cloud.getOwner() instanceof EnderDragon;
        });
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (!list.isEmpty()) {
            AreaEffectCloud areaeffectcloudentity = list.get(0);
            areaeffectcloudentity.setRadius(areaeffectcloudentity.getRadius() - 0.5F);
            worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundSource.NEUTRAL, 1.0F, 1.0F);
            return InteractionResultHolder.sidedSuccess(this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(Items.DRAGON_BREATH)), worldIn.isClientSide);
        } else {
            HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.SOURCE_ONLY);
            if (raytraceresult.getType() == HitResult.Type.MISS) {
                return InteractionResultHolder.pass(itemstack);
            } else {
                if (raytraceresult.getType() == HitResult.Type.BLOCK) {
                    BlockPos blockpos = ((BlockHitResult)raytraceresult).getBlockPos();
                    if (!worldIn.mayInteract(playerIn, blockpos)) {
                        return InteractionResultHolder.pass(itemstack);
                    }

                    if (worldIn.getFluidState(blockpos).is(FluidTags.WATER)) {
                        worldIn.playSound(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                        worldIn.gameEvent(playerIn, GameEvent.FLUID_PICKUP, blockpos);
                        return InteractionResultHolder.sidedSuccess(this.turnBottleIntoItem(itemstack, playerIn, PotionUtils.setPotion(new ItemStack(Misc.POTION_MUG::get), Potions.WATER)), worldIn.isClientSide());
                    }
                }

                return InteractionResultHolder.pass(itemstack);
            }
        }
    }
}

package chaosdog.frivycat.items;

import chaosdog.frivycat.Misc;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.List;

public class Mug extends GlassBottleItem {
    public Mug(Properties builder) {
        super(builder);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        List<AreaEffectCloudEntity> list = worldIn.getEntitiesWithinAABB(AreaEffectCloudEntity.class, playerIn.getBoundingBox().grow(2.0D), (cloud) -> {
            return cloud != null && cloud.isAlive() && cloud.getOwner() instanceof EnderDragonEntity;
        });
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!list.isEmpty()) {
            AreaEffectCloudEntity areaeffectcloudentity = list.get(0);
            areaeffectcloudentity.setRadius(areaeffectcloudentity.getRadius() - 0.5F);
            worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            return ActionResult.func_233538_a_(this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(Items.DRAGON_BREATH)), worldIn.isRemote());
        } else {
            RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
            if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
                return ActionResult.resultPass(itemstack);
            } else {
                if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                    BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getPos();
                    if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                        return ActionResult.resultPass(itemstack);
                    }

                    if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                        worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        return ActionResult.func_233538_a_(this.turnBottleIntoItem(itemstack, playerIn, PotionUtils.addPotionToItemStack(new ItemStack(Misc.POTION_MUG), Potions.WATER)), worldIn.isRemote());
                    }
                }

                return ActionResult.resultPass(itemstack);
            }
        }
    }
}

package chaosdog.frivycat.items;

import chaosdog.frivycat.entities.projectile.EasterEggProjectile;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class EasterEgg extends EggItem {
    private Object Entities;

    public EasterEgg(Properties builder) {
        super(builder);
        DispenserBlock.registerDispenseBehavior(this, new ProjectileDispenseBehavior() {
            @Override
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return Util.make(new EasterEggProjectile(worldIn, position.getX(), position.getY(), position.getZ()), (easteregg) -> {
                    easteregg.setItem(stackIn);
                });
            }
        });
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
             ItemStack itemstack = playerIn.getHeldItem(handIn);
             worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
             if (!worldIn.isRemote) {
                 EasterEggProjectile eastereggprojectile = new EasterEggProjectile(worldIn, playerIn);
                 eastereggprojectile.setItem(itemstack);
                 eastereggprojectile.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
                 worldIn.addEntity(eastereggprojectile);
             }

            playerIn.addStat(Stats.ITEM_USED.get(this));
             if (!playerIn.abilities.isCreativeMode) {
                 itemstack.shrink(1);
             }

             return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
         }

}


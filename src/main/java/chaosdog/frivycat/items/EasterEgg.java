package chaosdog.frivycat.items;

import chaosdog.frivycat.entities.projectile.EasterEggProjectile;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class EasterEgg extends EggItem {
    private Object Entities;

    public EasterEgg(Properties builder) {
        super(builder);
        DispenserBlock.registerBehavior(this, new AbstractProjectileDispenseBehavior() {

            @Override
            protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
                return Util.make(new EasterEggProjectile(worldIn, position.x(), position.y(), position.z()), (easteregg) -> {
                    easteregg.setItem(stackIn);
                });
            }
        });
    }

    public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
             ItemStack itemstack = playerIn.getItemInHand(handIn);
             worldIn.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (worldIn.getRandom().nextFloat() * 0.4F + 0.8F));
             if (!worldIn.isClientSide) {
                 EasterEggProjectile eastereggprojectile = new EasterEggProjectile(worldIn, playerIn);
                 eastereggprojectile.setItem(itemstack);
                 eastereggprojectile.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.5F, 1.0F);
                 worldIn.addFreshEntity(eastereggprojectile);
             }

            playerIn.awardStat(Stats.ITEM_USED.get(this));
             if (!playerIn.getAbilities().instabuild) {
                 itemstack.shrink(1);
             }

             return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
         }

}


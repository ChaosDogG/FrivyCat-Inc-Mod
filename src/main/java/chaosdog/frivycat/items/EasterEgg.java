package chaosdog.frivycat.items;

import net.minecraft.item.EggItem;

public class EasterEgg extends EggItem {
    public EasterEgg(Properties builder) {
        super(builder);
    }

    /*public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
             ItemStack itemstack = playerIn.getHeldItem(handIn);
             worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
             if (!worldIn.isRemote) {
                 EntityType<Entity> entityEntityType = null;
                 EasterEggProjectile eastereggprojectile = new EasterEggProjectile(Entities.EASTER_EGG_PROJECTILE, playerIn, null);
                 eastereggprojectile.setItem(itemstack);
                 eastereggprojectile.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
                 worldIn.addEntity(eastereggprojectile);
             }

            playerIn.addStat(Stats.ITEM_USED.get(this));
             if (!playerIn.abilities.isCreativeMode) {
                 itemstack.shrink(1);
             }

             return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
         }*/

}


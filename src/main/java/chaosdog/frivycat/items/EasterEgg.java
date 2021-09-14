package chaosdog.frivycat.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EasterEgg extends Item {
    public EasterEgg(Properties builder) {
        super(builder);
    }

    /*public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
       * ItemStack itemstack = playerIn.getHeldItem(handIn);
       * worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        *if (!worldIn.isRemote) {
         *   EasterEgg easteregg = new EasterEgg(worldIn, playerIn);
          *  easteregg.setItem(itemstack);
           * easteregg.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            *worldIn.addEntity(easteregg);
        }*
*
 *       playerIn.addStat(Stats.ITEM_USED.get(this));
  *      if (!playerIn.abilities.isCreativeMode) {
   *         itemstack.shrink(1);
    *    }
*
 *       return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
  *  }
*/
    private void setDirectionAndMovement(PlayerEntity playerIn, float rotationPitch, float rotationYaw, float v, float v1, float v2) {
    }

    private void setItem(ItemStack itemstack) {
    }
}


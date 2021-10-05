package chaosdog.frivycat.effects;

import chaosdog.frivycat.ModEffects;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.Hand;

public class ModEffect extends Effect {
    public ModEffect(EffectType type, int liquidColor) {
        super(type, liquidColor);
    }

    @Override
    public void performEffect(LivingEntity living, int amplifier) {
        if(this == ModEffects.SLIPPERY.get()) {
            if(!(living instanceof PlayerEntity)) {
                living.entityDropItem(living.getHeldItem(Hand.MAIN_HAND));
                living.entityDropItem(living.getHeldItem(Hand.OFF_HAND));
                living.setHeldItem(Hand.MAIN_HAND, ItemStack.EMPTY);
                living.setHeldItem(Hand.OFF_HAND, ItemStack.EMPTY);
                living.entityDropItem(living.getItemStackFromSlot(EquipmentSlotType.HEAD));
                living.entityDropItem(living.getItemStackFromSlot(EquipmentSlotType.CHEST));
                living.entityDropItem(living.getItemStackFromSlot(EquipmentSlotType.LEGS));
                living.entityDropItem(living.getItemStackFromSlot(EquipmentSlotType.FEET));
                living.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                living.setItemStackToSlot(EquipmentSlotType.CHEST, ItemStack.EMPTY);
                living.setItemStackToSlot(EquipmentSlotType.LEGS, ItemStack.EMPTY);
                living.setItemStackToSlot(EquipmentSlotType.FEET, ItemStack.EMPTY);
                if(living.isPassenger()) {
                    living.dismount();
                }
                if (living instanceof SheepEntity){
                    ((SheepEntity) living).setSheared(true);
                }
            }else {
                PlayerEntity player = (PlayerEntity) living;
                for(int i = 0; i<player.inventory.getSizeInventory(); ++i) {
                    ItemStack item = player.inventory.getStackInSlot(i);
                    if(!item.isEmpty() && EnchantmentHelper.hasBindingCurse(item)) {
                        EnchantmentHelper.getEnchantments(item).clear();
                    }
                }
                player.inventory.dropAllItems();
                if(player.isPassenger()){
                    player.dismount();
                }
            }
        }
        /*if(this == ModEffects.CREATIVE_LIKE.get()) {
            if(living instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) living;
                player.abilities.allowFlying = true;
                player.abilities.isCreativeMode = true;
                player.abilities.disableDamage = true;
            }
        }else{
            if(living instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) living;
                player.abilities.allowFlying = false;
                player.abilities.isCreativeMode = false;
                player.abilities.disableDamage = false;
            }
        }*/
    }
    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}

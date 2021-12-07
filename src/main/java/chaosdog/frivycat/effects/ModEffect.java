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
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

import java.util.Arrays;

public class ModEffect extends Effect {
    public ModEffect(EffectType type, int liquidColor) {
        super(type, liquidColor);
    }

    @Override
    public void performEffect(LivingEntity living, int amplifier) {

        //boolean hasCreativeLike = living.isPotionActive(ModEffects.CREATIVE_LIKE.get());

        if(this == ModEffects.SLIPPERY.get()) {
            if(!(living instanceof PlayerEntity)) {
                for (Hand hand1 : Arrays.asList(Hand.MAIN_HAND, Hand.OFF_HAND)) {
                    living.entityDropItem(living.getHeldItem(hand1));
                }
                for (Hand hand : Arrays.asList(Hand.MAIN_HAND, Hand.OFF_HAND)) {
                    living.setHeldItem(hand, ItemStack.EMPTY);
                }
                for (EquipmentSlotType slotType : Arrays.asList(EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET)) {
                    living.entityDropItem(living.getItemStackFromSlot(slotType));
                }
                for (EquipmentSlotType equipmentSlotType : Arrays.asList(EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET)) {
                    living.setItemStackToSlot(equipmentSlotType, ItemStack.EMPTY);
                }
                for (DamageSource damageSource : Arrays.asList(DamageSource.ANVIL, DamageSource.GENERIC, DamageSource.FALLING_BLOCK, DamageSource.CRAMMING, DamageSource.SWEET_BERRY_BUSH)) {
                    living.isInvulnerableTo(damageSource);
                }
                if(living.isPassenger()) {
                    living.dismount();
                }
                if (living instanceof SheepEntity){
                    if(((SheepEntity) living).isShearable()){
                        ((SheepEntity) living).setSheared(true);
                    }
                }
            }else {
                PlayerEntity player = (PlayerEntity) living;
                for(int i = 0; i<player.inventory.getSizeInventory(); ++i) {
                    ItemStack item = player.inventory.getStackInSlot(i);
                    if(!item.isEmpty() && EnchantmentHelper.hasBindingCurse(item)) {
                        EnchantmentHelper.getEnchantments(item).clear();
                    }
                }
                for (DamageSource damageSource : Arrays.asList(DamageSource.ANVIL, DamageSource.GENERIC, DamageSource.FALLING_BLOCK, DamageSource.CRAMMING, DamageSource.SWEET_BERRY_BUSH)) {
                    player.isInvulnerableTo(damageSource);
                }
                player.inventory.dropAllItems();
                if(player.isPassenger()){
                    player.dismount();
                }
            }
        }
        /*if(!hasCreativeLike) {
            if(living instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) living;
                player.abilities.allowFlying = false;
                player.abilities.isCreativeMode = false;
                player.abilities.disableDamage = false;
            }
        }else{
            if(living instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) living;
                player.abilities.allowFlying = true;
                player.abilities.isCreativeMode = true;
                player.abilities.disableDamage = true;
            }
        }*/
    }
    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}

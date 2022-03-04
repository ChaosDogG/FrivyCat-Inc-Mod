package chaosdog.frivycat.effects;

import chaosdog.frivycat.ModEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.Arrays;

public class ModEffect extends MobEffect {
    public ModEffect(MobEffectCategory type, int liquidColor) {
        super(type, liquidColor);
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplifier) {

        //boolean hasCreativeLike = living.isPotionActive(ModEffects.CREATIVE_LIKE.get());

        if(this == ModEffects.SLIPPERY.get()) {
            if(!(living instanceof Player)) {
                for (EquipmentSlot hand1 : Arrays.asList(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)) {
                    living.discard(living.getItemBySlot(hand1));
                }
                for (EquipmentSlot hand : Arrays.asList(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)) {
                    living.setItemSlot(hand, ItemStack.EMPTY);
                }
                for (EquipmentSlot slotType : Arrays.asList(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET)) {
                    living.entityDropItem(living.getItemBySlot(slotType));
                }
                for (EquipmentSlot equipmentSlotType : Arrays.asList(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET)) {
                    living.setItemSlot(equipmentSlotType, ItemStack.EMPTY);
                }
                for (DamageSource damageSource : Arrays.asList(DamageSource.ANVIL, DamageSource.GENERIC, DamageSource.FALLING_BLOCK, DamageSource.CRAMMING, DamageSource.SWEET_BERRY_BUSH)) {
                    living.isInvulnerableTo(damageSource);
                }
                if(living.isPassenger()) {
                    living.ejectPassengers();
                }
                if (living instanceof Sheep){
                    if(!((Sheep) living).isSheared()){
                        ((Sheep) living).setSheared(true);
                    }
                }
            }else {
                Player player = (Player) living;
                for(int i = 0; i< player.getInventory().getContainerSize(); ++i) {
                    ItemStack item = player.getInventory().getItem(i);
                    if(!item.isEmpty() && EnchantmentHelper.hasBindingCurse(item)) {
                        EnchantmentHelper.getEnchantments(item).clear();
                    }
                }
                for (DamageSource damageSource : Arrays.asList(DamageSource.ANVIL, DamageSource.GENERIC, DamageSource.FALLING_BLOCK, DamageSource.CRAMMING, DamageSource.SWEET_BERRY_BUSH)) {
                    player.isInvulnerableTo(damageSource);
                }
                player.getInventory().dropAll();
                if(player.isPassenger()){
                    player.ejectPassengers();
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

package chaosdog.frivycat.items;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class Butter extends Item {
    public Butter(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if(entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            living.attackEntityFrom(DamageSource.GENERIC, 0.0f);
            if(!(entity instanceof PlayerEntity)) {
                living.onItemPickup(living, 1);
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
                living.canPickUpItem(ItemStack.EMPTY);
                living.addTag("buttered");
            }else {
                for(int i = 0; i<player.inventory.getSizeInventory(); ++i) {
                    ItemStack item = player.inventory.getStackInSlot(i);
                    if(!item.isEmpty() && EnchantmentHelper.hasBindingCurse(item)) {
                        EnchantmentHelper.getEnchantments(item).clear();
                    }
                }
                player.inventory.dropAllItems();
            }
        }
        if(!player.isCreative()) {
            stack.shrink(1);
        }
        return true;
    }
}

package chaosdog.frivycat.items;

import chaosdog.frivycat.Misc;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.NonNullList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class PotionMug extends PotionItem implements IItemColor {
    private final java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Item>, IItemColor> colors = new java.util.HashMap<>();
    public PotionMug(Properties builder) {
        super(builder);
    }
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
        if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack);
        }

        if (!worldIn.isRemote) {
            for(EffectInstance effectinstance : PotionUtils.getEffectsFromStack(stack)) {
                if (effectinstance.getPotion().isInstant()) {
                    effectinstance.getPotion().affectEntity(playerentity, playerentity, entityLiving, effectinstance.getAmplifier(), 1.0D);
                } else {
                    entityLiving.addPotionEffect(new EffectInstance(effectinstance));
                }
            }
        }

        if (playerentity != null) {
            playerentity.addStat(Stats.ITEM_USED.get(this));
            if (!playerentity.abilities.isCreativeMode) {
                stack.shrink(1);
            }
        }

        if (playerentity == null || !playerentity.abilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Misc.MUG::get);
            }

            if (playerentity != null) {
                playerentity.inventory.addItemStackToInventory(new ItemStack(Misc.MUG::get));
            }
        }

        return stack;
    }

    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
            for(Potion potion : Registry.POTION) {
                if (potion != Potions.EMPTY) {
                    items.add(PotionUtils.addPotionToItemStack(new ItemStack(this), potion));
                }
            }
        }

    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        IItemColor iitemcolor = this.colors.get(stack.getItem().delegate);
        return iitemcolor == null ? -1 : iitemcolor.getColor(stack, tintIndex);
    }
}

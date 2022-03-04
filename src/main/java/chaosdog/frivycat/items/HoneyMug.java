package chaosdog.frivycat.items;

import chaosdog.frivycat.Misc;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HoneyMug extends HoneyBottleItem {
    public HoneyMug(Properties builder) {
        super(builder);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof ServerPlayer) {
            ServerPlayer serverplayerentity = (ServerPlayer)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!worldIn.isClientSide) {
            entityLiving.removeEffect(MobEffects.POISON);
        }

        if (stack.isEmpty()) {
            return new ItemStack(Misc.MUG::get);
        } else {
            if (entityLiving instanceof Player && !((Player)entityLiving).getAbilities().instabuild) {
                ItemStack itemstack = new ItemStack(Misc.MUG::get);
                Player playerentity = (Player)entityLiving;
                if (!playerentity.getInventory().add(itemstack)) {
                    playerentity.drop(itemstack, false);
                }
            }

            return stack;
        }
    }
}

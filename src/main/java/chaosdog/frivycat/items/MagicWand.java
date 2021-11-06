package chaosdog.frivycat.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

import java.util.Objects;

public class MagicWand extends Item {
    public MagicWand(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        
        if(!world.isRemote){
            PlayerEntity playerIn = Objects.requireNonNull(context.getPlayer());
            BlockState blockIn = world.getBlockState(context.getPos());
            
            //randomEnchant(blockIn, context, playerIn);
            stack.damageItem(1, playerIn, player -> player.sendBreakAnimation(context.getHand()));
        }
        return super.onItemUseFirst(stack, context);
    }
    //TODO this should randomly enchant every item in the player's inventory when they right-click on an enchant table
    /*private void randomEnchant(BlockState blockIn, ItemUseContext context, PlayerEntity playerIn) {
        if(isEnchantTable(blockIn)) {
            if(playerIn.experienceLevel == 3) {
                applyRandEnchant(context.getItem(), context.getPlayer());
            }else{
                playerIn.sendStatusMessage(new TranslationTextComponent("message.magic_wand.failed").mergeStyle(TextFormatting.DARK_RED), true);
            }
        }
    }

    private void applyRandEnchant(ItemStack item, PlayerEntity player, int id) {
        player.inventory.getSizeInventory();
        item.addEnchantment(EnchantmentHelper.addRandomEnchantment(nextInt, item, 10, true));
    }*/

    private boolean isEnchantTable(BlockState blockIn) {
        return blockIn.getBlock() == Blocks.ENCHANTING_TABLE;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}

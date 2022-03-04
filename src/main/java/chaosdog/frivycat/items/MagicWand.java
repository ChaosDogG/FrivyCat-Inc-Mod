package chaosdog.frivycat.items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public class MagicWand extends Item {
    public MagicWand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level world = context.getLevel();
        
        if(!world.isClientSide){
            Player playerIn = context.getPlayer();
            BlockState blockIn = world.getBlockState(context.getClickedPos());
            
            //randomEnchant(blockIn, context, playerIn);
            assert playerIn != null;
            context.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(context.getPlayer()),
                    (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
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
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

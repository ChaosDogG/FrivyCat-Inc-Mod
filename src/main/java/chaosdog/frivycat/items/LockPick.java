package chaosdog.frivycat.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

import java.util.Objects;
import java.util.stream.Stream;

public class LockPick extends Item {
    public LockPick(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level world = context.getLevel();

        if(!world.isClientSide) {
            Player playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getClickedPos());
            
            rightClickOnLockableBlock(clickedBlock, context, playerEntity);
            context.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(context.getPlayer()),
                    (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnLockableBlock(BlockState clickedBlock, UseOnContext context,
                                           Player playerEntity) {
        //TODO, make this actually override a locked tile entity and force open it
        if(blockCanBeLocked(clickedBlock)) {
            if(!playerEntity.isCreative()) {
                openLockedBlock(context.getLevel(), context.getClickedPos());
            } else if(playerEntity.isCreative()) {
                yeetLockedBlock(context.getLevel(), context.getClickedPos());
            }
        }
    }

    private void yeetLockedBlock(Level world, BlockPos pos) {
        world.destroyBlock(pos, false);
    }

    private boolean blockCanBeLocked(BlockState clickedBlock) {
        return Stream.of(Tags.Blocks.CHESTS, Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.SMOKER, Tags.Blocks.BARRELS, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.HOPPER).anyMatch(block -> clickedBlock.getBlock() == block);
    }
    private void openLockedBlock(Level world, BlockPos pos) {
        world.destroyBlock(pos, true);
    }

    public boolean isPiglinCurrency(ItemStack stack) {
        return true;
    }
}

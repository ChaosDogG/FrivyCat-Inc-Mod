package chaosdog.frivycat.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;

import java.util.Objects;
import java.util.stream.Stream;

import net.minecraft.item.Item.Properties;

public class LockPick extends Item {
    public LockPick(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if(!world.isRemote) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getPos());
            
            rightClickOnLockableBlock(clickedBlock, context, playerEntity);
            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnLockableBlock(BlockState clickedBlock, ItemUseContext context,
                                           PlayerEntity playerEntity) {
        //TODO, make this actually override a locked tile entity and force open it
        if(blockCanBeLocked(clickedBlock)) {
            if(!playerEntity.isCreative()) {
                openLockedBlock(context.getWorld(), context.getPos());
            } else if(playerEntity.isCreative()) {
                yeetLockedBlock(context.getWorld(), context.getPos());
            }
        }
    }

    private void yeetLockedBlock(World world, BlockPos pos) {
        world.destroyBlock(pos, false);
    }

    private boolean blockCanBeLocked(BlockState clickedBlock) {
        return Stream.of(Tags.Blocks.CHESTS, Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.SMOKER, Tags.Blocks.BARRELS, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.HOPPER).anyMatch(block -> clickedBlock.getBlock() == block);
    }
    private void openLockedBlock(World world, BlockPos pos) {
        world.destroyBlock(pos, true);
    }

    public boolean isPiglinCurrency(ItemStack stack) {
        return true;
    }
}

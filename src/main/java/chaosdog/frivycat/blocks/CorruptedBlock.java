package chaosdog.frivycat.blocks;

import chaosdog.frivycat.Gems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CorruptedBlock extends Block {
    public CorruptedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entityIn;
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entityIn;
                if(player.isAlive()) {
                    player.sendStatusMessage(new TranslationTextComponent("message.corrupted_block_collide").mergeStyle(TextFormatting.DARK_RED), true);
                }
            }
            if(!(living.getTags().contains("corrupted")) && !(living.getHeldItemMainhand().getItem() == Gems.CORRUPTED_DIAMOND.get()))
            living.setHealth(0);
        }
        if(entityIn instanceof ItemEntity) {
            ItemEntity item = (ItemEntity) entityIn;
            item.setInfinitePickupDelay();
        }
        entityIn.setMotionMultiplier(state, new Vector3d(2.0D, 2.0F, 2.0D));
    }

}

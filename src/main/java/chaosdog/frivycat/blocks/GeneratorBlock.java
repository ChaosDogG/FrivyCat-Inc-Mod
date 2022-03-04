package chaosdog.frivycat.blocks;

import chaosdog.frivycat.FCConfig;
import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Random;

public class GeneratorBlock extends Block {
    private final Type type;

    public GeneratorBlock(Type type) {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(10f, 100f).sound(SoundType.STONE));
        this.type = type;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
        Block blockAbove = world.getBlockState(pos.above()).getBlock();
        if((blockAbove instanceof AirBlock || blockAbove == Blocks.WATER) && rand.nextInt(type.getRarity()) == 0) {
            FrivyCatMod.LOG.debug("Spawning item!");
            ItemStack stack = new ItemStack(type.getItem(rand));
            Block.popResource(world, pos.above(), stack);
        }

        scheduleNextTick(world, pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, Level world, BlockPos currentPos, BlockPos facingPos) {
        scheduleNextTick(world, currentPos);
        return state;
    }

    private void scheduleNextTick(Level world, BlockPos pos) {
        if (!world.isClientSide() && !world.getBlockTicks().willTickThisTick(pos, this)) {
            world.getBlockTicks().hasScheduledTick(pos, this);
        }
    }

    public enum Type {
        LOG(FCConfig.SETTINGS.generators.logRarity),
        IRON(FCConfig.SETTINGS.generators.ironRarity, Items.IRON_INGOT),
        APPLE(FCConfig.SETTINGS.generators.appleRarity, Items.APPLE),
        GOLD(FCConfig.SETTINGS.generators.goldRarity, Items.GOLD_INGOT),
        DIAMOND(FCConfig.SETTINGS.generators.diamondRarity, Items.DIAMOND),
        OBSIDIAN(FCConfig.SETTINGS.generators.obsidianRarity, Blocks.OBSIDIAN.asItem());

        private final Item item;
        private final int rarity;

        Type(ForgeConfigSpec.IntValue rarity, Item item) {
            this.item = item;
            this.rarity = rarity.get();
        }

        Type(ForgeConfigSpec.IntValue rarity) {
            item = null;
            this.rarity = rarity.get();
        }

        public Item getItem(Random rand) {
            if(item == null) { return BlockTags.LOGS.getRandomElement(rand).asItem(); }
            return item;
        }

        public int getRarity() { return rarity; }
    }
}

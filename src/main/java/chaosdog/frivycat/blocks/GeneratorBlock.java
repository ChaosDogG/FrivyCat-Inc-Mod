package chaosdog.frivycat.blocks;

import chaosdog.frivycat.FCConfig;
import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class GeneratorBlock extends Block {
    private final Type type;

    public GeneratorBlock(Type type) {
        super(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE));
        this.type = type;
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        Block blockAbove = world.getBlockState(pos.up()).getBlock();
        if((blockAbove instanceof AirBlock || blockAbove == Blocks.WATER) && rand.nextInt(type.getRarity()) == 0) {
            FrivyCatMod.LOG.debug("Spawning item!");
            ItemStack stack = new ItemStack(type.getItem(rand));
            Block.spawnAsEntity(world, pos.up(), stack);
        }

        scheduleNextTick(world, pos);
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        scheduleNextTick(world, currentPos);
        return state;
    }

    private void scheduleNextTick(IWorld world, BlockPos pos) {
        if (!world.isRemote() && !world.getPendingBlockTicks().isTickScheduled(pos, this)) {
            world.getPendingBlockTicks().scheduleTick(pos, this, 1);
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

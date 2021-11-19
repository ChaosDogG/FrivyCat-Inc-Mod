package chaosdog.frivycat.blocks;

import chaosdog.frivycat.FrivyCatMod;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class GeneratorBlock extends Block {
    private final Type type;

    public GeneratorBlock(Type type) {
        super(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).hardnessAndResistance(10f, 100f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).tickRandomly());
        this.type = type;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        if(world.getBlockState(pos.up()).getBlock() instanceof AirBlock) {
            FrivyCatMod.LOG.debug("Spawing item!");
            ItemStack stack = new ItemStack(type.getItem(rand));
            Block.spawnAsEntity(world, pos.up(), stack);
        }
    }

    public enum Type {
        LOG,
        IRON(Items.IRON_INGOT),
        APPLE(Items.APPLE),
        GOLD(Items.GOLD_INGOT),
        DIAMOND(Items.DIAMOND),
        OBSIDIAN(Blocks.OBSIDIAN.asItem());

        private final Item item;

        Type(Item item) { this.item = item; }

        Type() { item = null; }

        public Item getItem(Random rand) {
            if(item == null) { return BlockTags.LOGS.getRandomElement(rand).asItem(); }
            return item;
        }
    }
}

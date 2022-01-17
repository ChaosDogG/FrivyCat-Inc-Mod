package chaosdog.frivycat.world;

import chaosdog.frivycat.FrivyCatMod;
import chaosdog.frivycat.Utils;
import chaosdog.frivycat.world.dimension.FCDimensions;
import chaosdog.frivycat.world.gen.structures.FCStructures;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FCWorld {
    // cardinal directions
    public static Direction[] DIRECTIONS = {Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH};

    // blocks that normally make up the ground in Minecraft
    public static final Block[] GROUND = {
            Blocks.DIRT,
            Blocks.COARSE_DIRT,
            Blocks.GRAVEL,
            Blocks.SAND,
            Blocks.RED_SAND,
            Blocks.GRASS_BLOCK,
            Blocks.PODZOL,
            Blocks.SNOW_BLOCK,
            Blocks.STONE,
            Blocks.ANDESITE,
            Blocks.DIORITE,
            Blocks.GRANITE,
            Blocks.TERRACOTTA,
            Blocks.LIGHT_GRAY_TERRACOTTA,
            Blocks.WHITE_TERRACOTTA,
            Blocks.BROWN_TERRACOTTA,
            Blocks.YELLOW_TERRACOTTA,
            Blocks.RED_TERRACOTTA,
            Blocks.ORANGE_TERRACOTTA,
            Blocks.RED_SANDSTONE,
            Blocks.RED_SAND,
            Blocks.BLUE_ICE,
            Blocks.OBSIDIAN,
            Blocks.MAGMA_BLOCK,
            Blocks.BASALT
    };

    public static void init(IEventBus eventBus) {
        FrivyCatMod.LOG.info("Setting up world module");
        FCStructures.init(eventBus);
        FCDimensions.init(eventBus);
    }

    public static int getLowestY(IWorld world, BlockPos pos1, BlockPos pos2, Block... ground) {
        int deltaX = Math.abs(pos2.getX() - pos1.getX());
        int deltaZ = Math.abs(pos2.getZ() - pos1.getZ());
        ArrayList<Integer> yVals = new ArrayList<>();
        for(int x = 0; x < deltaX; x++) {
            for(int z = 0; z < deltaZ; z++) yVals.add(getGroundLevel(world, 0, 255, x + pos1.getX(), z + pos1.getZ(), ground));
        }
        return Utils.getMinValue(yVals);
    }
    public static int getLowestY(IWorld world, BlockPos pos1, BlockPos pos2) {
        return getLowestY(world, pos1, pos2, GROUND);
    }

    public static int getHighestY(IWorld world, BlockPos pos1, BlockPos pos2, Block... ground) {
        int deltaX = Math.abs(pos2.getX() - pos1.getX());
        int deltaZ = Math.abs(pos2.getZ() - pos1.getZ());
        ArrayList<Integer> yVals = new ArrayList<>();
        for(int x = 0; x < deltaX; x++) {
            for(int z = 0; z < deltaZ; z++) yVals.add(getGroundLevel(world, 0, 255, x + pos1.getX(), z + pos1.getZ(), ground));
        }
        return Utils.getMaxValue(yVals);
    }
    public static int getHighestY(IWorld world, BlockPos pos1, BlockPos pos2) {
        return getHighestY(world, pos1, pos2, GROUND);
    }

    public static int getGroundLevel(IWorld world, int minY, int maxY, int x, int z, boolean isUnderwater, Block... groundBlocks) {
        List<Block> replaceable = replaceable();
        int y;

        for (y = maxY; y > minY; y--) {
            BlockPos pos = new BlockPos(x, y, z);
            Block block = world.getBlockState(pos).getBlock();
            Block blockAbove = world.getBlockState(pos.up()).getBlock();
            if ((isUnderwater && Arrays.asList(groundBlocks).contains(block) && blockAbove == Blocks.WATER) || (Arrays.asList(groundBlocks).contains(block) && replaceable.contains(blockAbove))) return y;
        }
        return y;
    }
    public static int getGroundLevel(IWorld world, int minY, int maxY, int x, int z, Block... groundBlocks) { return getGroundLevel(world, minY, maxY, x, z, false, groundBlocks); }
    public static int getGroundLevel(IWorld world, int minY, int maxY, int x, int z) { return getGroundLevel(world, minY, maxY, x, z, false, GROUND); }

    public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> regConfFeature(String key, ConfiguredFeature<FC, ?> feature) { return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(FrivyCatMod.ID, key), feature); }
    public static List<Block> replaceable() {
        List<Block> blocks = new ArrayList<>(Arrays.asList(
                Blocks.AIR,
                Blocks.CAVE_AIR,
                Blocks.VOID_AIR,
                Blocks.SNOW,
                Blocks.GRASS,
                Blocks.TALL_GRASS,
                Blocks.FERN,
                Blocks.VINE,
                Blocks.LARGE_FERN,
                Blocks.BAMBOO,
                Blocks.BAMBOO_SAPLING,
                Blocks.SEAGRASS,
                Blocks.TALL_SEAGRASS
        ));

        blocks.addAll(BlockTags.LEAVES.getAllElements());
        blocks.addAll(BlockTags.FLOWERS.getAllElements());
        blocks.addAll(BlockTags.LOGS.getAllElements());
        return blocks;
    }
}

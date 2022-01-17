package chaosdog.frivycat;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FCConfig {
    public static final FCConfig SETTINGS;
    private static final Path PATH = Paths.get("config", FrivyCatMod.ID + "-common.toml");
    private static final ForgeConfigSpec SPEC;
    static {
        Pair<FCConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(FCConfig::new);
        SETTINGS = specPair.getLeft();
        SPEC = specPair.getRight();

        CommentedFileConfig configFile = CommentedFileConfig.builder(PATH)
                .sync()
                .autoreload()
                .writingMode(WritingMode.REPLACE)
                .build();
        configFile.load();
        configFile.save();
        SPEC.setConfig(configFile);
    }

    public final Structures structures;
    public final Generators generators;

    FCConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Frivy Cat Mod Settings\nMinecraft will need to be restarted if anything is changed").push("config");
        structures = new Structures(builder);
        generators = new Generators(builder);
    }

    public static class Structures {
        public final WorldGenOption deathFellAccidentWater;
        public final WorldGenOption chaosHead;
        public final WorldGenOption villagerSpawner;

        Structures(ForgeConfigSpec.Builder builder) {
            builder.comment("Structure Settings").push("structures");
            deathFellAccidentWater = new WorldGenOption(builder, true, 100, "Generate death.fell.accident.water Structure?", "deathFellAccidentWater");
            chaosHead = new WorldGenOption(builder, true, 100, "Generate ChaosDog's head?", "chaosHead");
            villagerSpawner = new WorldGenOption(builder, true, 100, "Generate villager spawners?", "villagerSpawner");
            builder.pop();
        }
    }

    public static class Generators {
        public final ForgeConfigSpec.IntValue logRarity;
        public final ForgeConfigSpec.IntValue appleRarity;
        public final ForgeConfigSpec.IntValue ironRarity;
        public final ForgeConfigSpec.IntValue goldRarity;
        public final ForgeConfigSpec.IntValue obsidianRarity;
        public final ForgeConfigSpec.IntValue diamondRarity;

        Generators(ForgeConfigSpec.Builder builder) {
            builder.comment("Item Generator Settings").push("generators");
            logRarity = builder.defineInRange("logRarity", 5, 1, Integer.MAX_VALUE);
            appleRarity = builder.defineInRange("appleRarity", 10, 1, Integer.MAX_VALUE);
            ironRarity = builder.defineInRange("ironRarity", 20, 1, Integer.MAX_VALUE);
            goldRarity = builder.defineInRange("goldRarity", 30, 1, Integer.MAX_VALUE);
            obsidianRarity = builder.defineInRange("obsidianRarity", 30, 1, Integer.MAX_VALUE);
            diamondRarity = builder.defineInRange("diamondRarity", 50, 1, Integer.MAX_VALUE);
            builder.pop();
        }
    }

    public static class WorldGenOption {
        public final ForgeConfigSpec.BooleanValue enabled;
        public final ForgeConfigSpec.IntValue chance;

        WorldGenOption(ForgeConfigSpec.Builder builder, boolean enabled, int chance, String comment, String name) {
            builder.comment(comment).push(name);
            this.enabled = builder.define("enabled", enabled);
            this.chance =  builder.defineInRange("chance", chance, 0, Integer.MAX_VALUE);
            builder.pop();
        }
    }

    public static void initConfig(ModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, SPEC);
    }
}
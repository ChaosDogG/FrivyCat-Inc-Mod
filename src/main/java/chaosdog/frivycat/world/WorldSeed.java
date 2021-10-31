package chaosdog.frivycat.world;

import chaosdog.frivycat.FrivyCatMod;

public class WorldSeed {
    private static long seed = -1;

    public static void setSeed(long seedInput) {
        seed = seedInput;
        if(seedInput != -1) FrivyCatMod.LOG.debug("Current world seed: " + seed);
    }

    public static long getSeed() { return seed; }
}

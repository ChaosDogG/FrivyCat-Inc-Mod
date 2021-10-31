package chaosdog.frivycat.world.structure.dimension;

import chaosdog.frivycat.Gems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.World;

import java.util.function.Supplier;

public enum FCDimensionType {
    PASSIVE_FIELDS(ParticleTypes.ENCHANTED_HIT, Gems.TOPAZ_BLOCK),
    WOODED_TERRORS(ParticleTypes.PORTAL, () -> Blocks.TNT),
    SPIRIT_REALM(ParticleTypes.CRIT, Gems.ZIRCON_BLOCK);

    private final IParticleData portalParticles;
    private final Supplier<Block> frame;
    private final ResourceLocation key;

    FCDimensionType(IParticleData portalParticles, Supplier<Block> frame) {
        key = new ResourceLocation("frivycat:" + name().toLowerCase());
        this.portalParticles = portalParticles;
        this.frame = frame;
    }

    public IParticleData getPortalParticles() {
        return portalParticles;
    }

    public Block getFrameBlock() {
        return frame.get();
    }

    public RegistryKey<World> getKey() {
        return RegistryKey.getOrCreateKey(Registry.WORLD_KEY, key);
    }

    public PointOfInterestType getPointOfInterestType() {
        switch(this) {
            case SPIRIT_REALM: return FCDimensions.SPIRIT_REALM_POI.get();
            case PASSIVE_FIELDS: return FCDimensions.PASSIVE_FIELDS_POI.get();
            case WOODED_TERRORS: return FCDimensions.WOODED_TERRORS_POI.get();
        }
        return null;
    }

    public ResourceLocation getName() {
        return key;
    }
}

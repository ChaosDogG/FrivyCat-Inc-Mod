package chaosdog.frivycat.entities.projectile;

import chaosdog.frivycat.Misc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EasterEggProjectile extends EggEntity {


    public EasterEggProjectile(EntityType<Entity> ent, World world) {
        super(EntityType.EGG, world);
    }

    public EasterEggProjectile(World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    public EasterEggProjectile(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            if (this.rand.nextInt(8) == 0) {
                int i = 1;
                if (this.rand.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    FoxEntity foxentity = EntityType.FOX.create(this.world);
                    assert foxentity != null;
                    foxentity.setGrowingAge(-24000);
                    foxentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                    this.world.addEntity(foxentity);
                }
            }

            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return Misc.EASTER_EGG.get();
    }
}

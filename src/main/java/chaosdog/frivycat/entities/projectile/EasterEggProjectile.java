package chaosdog.frivycat.entities.projectile;

import chaosdog.frivycat.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class EasterEggProjectile extends ProjectileItemEntity {
    private final EntityType<Entity> entityEntityType;

    public EasterEggProjectile(EntityType<Entity> type, World worldIn, EntityType<Entity> entityEntityType) {
        super((EntityType<? extends ProjectileItemEntity>) type, worldIn);
        this.entityEntityType = entityEntityType;
    }

    public EasterEggProjectile(World worldIn, LivingEntity throwerIn, EntityType<Entity> entityEntityType) {
        super(EntityType.EGG, throwerIn, worldIn);
        this.entityEntityType = entityEntityType;
    }

    public EasterEggProjectile(EntityType<Entity> entityEntityType, World world) {
        super((EntityType<? extends ProjectileItemEntity>) entityEntityType, world);
        this.entityEntityType = entityEntityType;
    }

    public EasterEggProjectile(RegistryObject<EntityType<Entity>> easterEggProjectile, PlayerEntity playerIn, EntityType<Entity> entityEntityType) {
        super(easterEggProjectile, playerIn, world);
        this.entityEntityType = entityEntityType;
    }

    @Override
    protected Item getDefaultItem() {
        return Items.EGG;
    }
}

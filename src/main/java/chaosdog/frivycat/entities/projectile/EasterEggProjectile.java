package chaosdog.frivycat.entities.projectile;

import chaosdog.frivycat.Misc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.Objects;

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
    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            if (this.rand.nextInt(8) == 0) {
                int i = 1;
                if (this.rand.nextInt(32) == 0) {
                    i = 4;
                }
                if (this.rand.nextInt(10) == 0) {
                    for (int j = 0; j < i; ++j) {
                        FoxEntity foxentity = EntityType.FOX.create(this.world);
                        assert foxentity != null;
                        foxentity.setGrowingAge(-24000);
                        foxentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        foxentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Misc.EASTER_EGG.get()));
                        this.world.addEntity(foxentity);
                    }
                }
                if (this.rand.nextInt(10) == 1) {
                    for (int k = 0; k < i; ++k) {
                        CatEntity catentity = EntityType.CAT.create(this.world);
                        assert catentity != null;
                        catentity.setGrowingAge(-24000);
                        catentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        catentity.setCatType(this.rand.nextInt(10));
                        this.world.addEntity(catentity);
                    }
                }
                if(this.rand.nextInt(10) == 2) {
                    for (int l = 0; l < i; ++l) {
                        WolfEntity wolfentity = EntityType.WOLF.create(this.world);
                        assert wolfentity != null;
                        wolfentity.setGrowingAge(-24000);
                        wolfentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        this.world.addEntity(wolfentity);
                    }
                }
                if(this.rand.nextInt(10) == 3) {
                    for (int m = 0; m < i; ++m) {
                        SheepEntity sheepentity = EntityType.SHEEP.create(this.world);
                        assert sheepentity != null;
                        sheepentity.setGrowingAge(-24000);
                        sheepentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        sheepentity.setFleeceColor(DyeColor.byId(this.rand.nextInt(15)));
                        if(this.rand.nextInt(2) == 0) {
                            if(sheepentity.getFleeceColor().getColorValue() == 0){
                                sheepentity.setCustomName(new StringTextComponent("Shaun"));
                            }else{
                            sheepentity.setCustomName(new StringTextComponent("jeb_"));
                            }
                            sheepentity.setCustomNameVisible(true);
                        }
                        this.world.addEntity(sheepentity);
                    }
                }
                if(this.rand.nextInt(10) == 4) {
                    for (int n = 0; n < i; ++n) {
                        PandaEntity pandaentity = EntityType.PANDA.create(this.world);
                        assert pandaentity != null;
                        pandaentity.setGrowingAge(-24000);
                        pandaentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        pandaentity.setMainGene(PandaEntity.Gene.getRandomType(this.rand));
                        pandaentity.setHiddenGene(PandaEntity.Gene.getRandomType(this.rand));
                        if(pandaentity.getMainGene() == PandaEntity.Gene.LAZY && pandaentity.getHiddenGene() == PandaEntity.Gene.AGGRESSIVE) {
                            pandaentity.setCustomName(new StringTextComponent("Genma").mergeStyle(TextFormatting.BOLD));
                            pandaentity.setCustomNameVisible(true);
                        }
                        this.world.addEntity(pandaentity);
                    }
                }
                if(this.rand.nextInt(10) == 5) {
                    for (int o = 0; o < i; ++o) {
                        StriderEntity striderentity = EntityType.STRIDER.create(this.world);
                        assert striderentity != null;
                        striderentity.setGrowingAge(-24000);
                        striderentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        this.world.addEntity(striderentity);
                    }
                }
                if(this.rand.nextInt(10) == 6) {
                    for (int p = 0; p < i; ++p) {
                        HorseEntity horseentity = EntityType.HORSE.create(this.world);
                        assert horseentity != null;
                        horseentity.setGrowingAge(-24000);
                        horseentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        this.world.addEntity(horseentity);
                    }
                }
                if(this.rand.nextInt(10) == 7) {
                    for (int q = 0; q < i; ++q) {
                        BeeEntity beeentity = EntityType.BEE.create(this.world);
                        assert beeentity != null;
                        beeentity.setGrowingAge(-24000);
                        beeentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        this.world.addEntity(beeentity);
                    }
                }
                if(this.rand.nextInt(10) == 8) {
                    for (int r = 0; r < i; ++r) {
                        LlamaEntity llamaentity = EntityType.LLAMA.create(this.world);
                        assert llamaentity != null;
                        llamaentity.setGrowingAge(-24000);
                        llamaentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        llamaentity.setVariant(this.rand.nextInt(4));
                        if(llamaentity.getVariant() == 2) {
                            llamaentity.setCustomName(new StringTextComponent("Paul").mergeStyle(TextFormatting.LIGHT_PURPLE));
                        }
                        if(llamaentity.getVariant() == 3) {
                            llamaentity.setCustomName(new StringTextComponent("Carl").mergeStyle(TextFormatting.GREEN));
                        }
                        this.world.addEntity(llamaentity);
                    }
                }
                if(this.rand.nextInt(10) == 9) {
                    for (int s = 0; s < i; ++s) {
                        VillagerEntity villagerentity = EntityType.VILLAGER.create(this.world);
                        assert villagerentity != null;
                        villagerentity.setGrowingAge(-24000);
                        villagerentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                        villagerentity.setCustomName(new StringTextComponent("Villager #" + this.rand.nextInt(101)));
                        if(Objects.requireNonNull(villagerentity.getCustomName()).getString().equals("Villager #0")) {
                            villagerentity.setHealth(0);
                        }
                        if(Objects.requireNonNull(villagerentity.getCustomName()).getString().equals("Villager #4")) {
                            villagerentity.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Misc.MUSTACHE.get()));
                        }
                        if(Objects.requireNonNull(villagerentity.getCustomName()).getString().equals("Villager #9")) {
                            villagerentity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Misc.MIC.get()));
                        }
                        villagerentity.setCustomNameVisible(true);
                        villagerentity.setShakeHeadTicks(20);
                        this.world.addEntity(villagerentity);
                    }
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

package chaosdog.frivycat.entities.projectile;

import chaosdog.frivycat.Misc;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import java.util.Objects;

public class EasterEggProjectile extends ThrownEgg {


    public EasterEggProjectile(EntityType<? extends EasterEggProjectile> ent, Level world) {
        super(EntityType.EGG, world);
    }

    public EasterEggProjectile(Level worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    public EasterEggProjectile(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }
                if (this.random.nextInt(10) == 0) {
                    for (int j = 0; j < i; ++j) {
                        Fox foxentity = EntityType.FOX.create(this.level);
                        assert foxentity != null;
                        foxentity.setAge(-24000);
                        foxentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        foxentity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Misc.EASTER_EGG.get()));
                        this.level.addFreshEntity(foxentity);
                    }
                }
                if (this.random.nextInt(10) == 1) {
                    for (int k = 0; k < i; ++k) {
                        Cat catentity = EntityType.CAT.create(this.level);
                        assert catentity != null;
                        catentity.setAge(-24000);
                        catentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        catentity.setCatType(this.random.nextInt(10));
                        this.level.addFreshEntity(catentity);
                    }
                }
                if(this.random.nextInt(10) == 2) {
                    for (int l = 0; l < i; ++l) {
                        Wolf wolfentity = EntityType.WOLF.create(this.level);
                        assert wolfentity != null;
                        wolfentity.setAge(-24000);
                        wolfentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level.addFreshEntity(wolfentity);
                    }
                }
                if(this.random.nextInt(10) == 3) {
                    for (int m = 0; m < i; ++m) {
                        Sheep sheepentity = EntityType.SHEEP.create(this.level);
                        assert sheepentity != null;
                        sheepentity.setAge(-24000);
                        sheepentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        sheepentity.setColor(DyeColor.byId(this.random.nextInt(15)));
                        if(this.random.nextInt(2) == 0) {
                            if(sheepentity.getColor().getId() == 0){
                                sheepentity.setCustomName(new TextComponent("Shaun"));
                            }else{
                            sheepentity.setCustomName(new TextComponent("jeb_"));
                            }
                            sheepentity.setCustomNameVisible(true);
                        }
                        this.level.addFreshEntity(sheepentity);
                    }
                }
                if(this.random.nextInt(10) == 4) {
                    for (int n = 0; n < i; ++n) {
                        Panda pandaentity = EntityType.PANDA.create(this.level);
                        assert pandaentity != null;
                        pandaentity.setAge(-24000);
                        pandaentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        pandaentity.setMainGene(Panda.Gene.getRandom(this.random));
                        pandaentity.setHiddenGene(Panda.Gene.getRandom(this.random));
                        if(pandaentity.getMainGene() == Panda.Gene.LAZY && pandaentity.getHiddenGene() == Panda.Gene.AGGRESSIVE) {
                            pandaentity.setCustomName(new TextComponent("Genma").withStyle(ChatFormatting.BOLD));
                            pandaentity.setCustomNameVisible(true);
                        }
                        this.level.addFreshEntity(pandaentity);
                    }
                }
                if(this.random.nextInt(10) == 5) {
                    for (int o = 0; o < i; ++o) {
                        Strider striderentity = EntityType.STRIDER.create(this.level);
                        assert striderentity != null;
                        striderentity.setAge(-24000);
                        striderentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level.addFreshEntity(striderentity);
                    }
                }
                if(this.random.nextInt(10) == 6) {
                    for (int p = 0; p < i; ++p) {
                        Horse horseentity = EntityType.HORSE.create(this.level);
                        assert horseentity != null;
                        horseentity.setAge(-24000);
                        horseentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level.addFreshEntity(horseentity);
                    }
                }
                if(this.random.nextInt(10) == 7) {
                    for (int q = 0; q < i; ++q) {
                        Bee beeentity = EntityType.BEE.create(this.level);
                        assert beeentity != null;
                        beeentity.setAge(-24000);
                        beeentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level.addFreshEntity(beeentity);
                    }
                }
                if(this.random.nextInt(10) == 8) {
                    for (int r = 0; r < i; ++r) {
                        Llama llamaentity = EntityType.LLAMA.create(this.level);
                        assert llamaentity != null;
                        llamaentity.setAge(-24000);
                        llamaentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        llamaentity.setVariant(this.random.nextInt(4));
                        if(llamaentity.getVariant() == 2) {
                            llamaentity.setCustomName(new TextComponent("Paul").withStyle(ChatFormatting.LIGHT_PURPLE));
                        }
                        if(llamaentity.getVariant() == 3) {
                            llamaentity.setCustomName(new TextComponent("Carl").withStyle(ChatFormatting.GREEN));
                        }
                        this.level.addFreshEntity(llamaentity);
                    }
                }
                if(this.random.nextInt(10) == 9) {
                    for (int s = 0; s < i; ++s) {
                        Villager villagerentity = EntityType.VILLAGER.create(this.level);
                        assert villagerentity != null;
                        villagerentity.setAge(-24000);
                        villagerentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        villagerentity.setCustomName(new TextComponent("Villager #" + this.random.nextInt(101)));
                        if(Objects.requireNonNull(villagerentity.getCustomName()).getString().equals("Villager #0")) {
                            villagerentity.setHealth(0);
                        }
                        if(Objects.requireNonNull(villagerentity.getCustomName()).getString().equals("Villager #4")) {
                            villagerentity.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Misc.MUSTACHE.get()));
                        }
                        if(Objects.requireNonNull(villagerentity.getCustomName()).getString().equals("Villager #9")) {
                            villagerentity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Misc.MIC.get()));
                        }
                        villagerentity.setCustomNameVisible(true);
                        villagerentity.setUnhappyCounter(20);
                        this.level.addFreshEntity(villagerentity);
                    }
                }
            }

            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return Misc.EASTER_EGG.get();
    }
}

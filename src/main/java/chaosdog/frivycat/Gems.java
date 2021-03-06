package chaosdog.frivycat;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.horse.ZombieHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class Gems {
    // registries (they don't need to be public)
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FrivyCatMod.ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // gemstones
    public static final RegistryObject<Item> RUBY = regGem("ruby");
    public static final RegistryObject<Item> SAPPHIRE = regGem("sapphire");
    public static final RegistryObject<Item> ZIRCON = regGem("zircon");
    public static final RegistryObject<Item> GARNET = regGem("garnet");
    public static final RegistryObject<Item> JADE = regGem("jade");
    public static final RegistryObject<Item> JASPER = regGem("jasper");
    public static final RegistryObject<Item> SPINEL = regGem("spinel");
    public static final RegistryObject<Item> TOPAZ = regGem("topaz");
    public static final RegistryObject<Item> AGATE = regGem("agate");

    // gem blocks
    public static final RegistryObject<Block> RUBY_BLOCK = regGemBlock("ruby");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = regGemBlock("sapphire");
    public static final RegistryObject<Block> ZIRCON_BLOCK = regGemBlock("zircon");
    public static final RegistryObject<Block> GARNET_BLOCK = regGemBlock("garnet");
    public static final RegistryObject<Block> JADE_BLOCK = regGemBlock("jade");
    public static final RegistryObject<Block> JASPER_BLOCK = regGemBlock("jasper");
    public static final RegistryObject<Block> SPINEL_BLOCK = regGemBlock("spinel");
    public static final RegistryObject<Block> TOPAZ_BLOCK = regGemBlock("topaz");
    public static final RegistryObject<Block> AGATE_BLOCK = regGemBlock("agate");

    // gem ores
    public static final RegistryObject<Block> RUBY_ORE = regGemOre("ruby");
    public static final RegistryObject<Block> SAPPHIRE_ORE = regGemOre("sapphire");
    public static final RegistryObject<Block> ZIRCON_ORE = regGemOre("zircon");
    public static final RegistryObject<Block> GARNET_ORE = regGemOre("garnet");
    public static final RegistryObject<Block> JADE_ORE = regGemOre("jade");
    public static final RegistryObject<Block> JASPER_ORE = regGemOre("jasper");
    public static final RegistryObject<Block> SPINEL_ORE = regGemOre("spinel");
    public static final RegistryObject<Block> TOPAZ_ORE = regGemOre("topaz");
    public static final RegistryObject<Block> AGATE_ORE = regGemOre("agate");

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOG.info("Setting up Gems");
        // register the registries
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
    }

    // registers a gem block
    private static RegistryObject<Block> regGemBlock(String name) {
        return Utils.regBlockWithItem(BLOCKS, ITEMS, name + "_block",
                new Block(AbstractBlock.Properties.from(Blocks.EMERALD_BLOCK)){
                    @Override
                    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
                        if (name.equals("ruby")) {
                            if(entityIn instanceof ZombieEntity) {
                                ZombieEntity rotting = (ZombieEntity) entityIn;
                                rotting.attackEntityFrom(DamageSource.MAGIC, Float.MAX_VALUE);
                            }
                            if(entityIn instanceof ZoglinEntity) {
                                ZoglinEntity zog = (ZoglinEntity) entityIn;
                                zog.attackEntityFrom(DamageSource.MAGIC, Float.MAX_VALUE);
                            }
                            if(entityIn instanceof ZombieHorseEntity) {
                                ZombieHorseEntity horse = (ZombieHorseEntity) entityIn;
                                horse.attackEntityFrom(DamageSource.MAGIC, Float.MAX_VALUE);
                            }
                        }
                        if(name.equals("sapphire")) {
                            if(entityIn instanceof PlayerEntity) {
                                PlayerEntity player = (PlayerEntity) entityIn;
                                if(player.getUniqueID().equals(UUID.fromString("0b177a6f-bbd5-4c32-87d6-aa44b5034933"))) {
                                    player.addPotionEffect(new EffectInstance(Effects.LUCK, 1000000, 255));
                                    player.addPotionEffect(new EffectInstance(Effects.SATURATION, 10000000, 255));
                                    player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 10000000));
                                }
                            }
                            if(entityIn instanceof VillagerEntity) {
                                VillagerEntity villager = (VillagerEntity) entityIn;
                                if(!(villager.getVillagerData().getProfession() == VillagerProfession.NONE) && !(villager.getVillagerData().getProfession() == VillagerProfession.NITWIT)) {
                                    villager.removePotionEffect(Effects.SLOWNESS);
                                    villager.addPotionEffect(new EffectInstance(Effects.REGENERATION, 50, 5));
                                    villager.addPotionEffect(new EffectInstance(Effects.GLOWING, 50, 5));
                                }
                                if(villager.getGrowingAge() < 0) {
                                    villager.setGrowingAge(0);
                                }
                            }
                        }
                        if(name.equals("zircon")) {
                            if(entityIn instanceof VillagerEntity) {
                                VillagerEntity villager = (VillagerEntity) entityIn;
                                if((villager.getVillagerData().getProfession() == VillagerProfession.NONE || villager.getVillagerData().getProfession() == VillagerProfession.NITWIT) && !(villager.getGrowingAge() < 0)) {
                                    villager.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 5000, 3));
                                    villager.setGlowing(false);
                                }
                            }
                        }
                        if(name.equals("garnet")) {
                            if(entityIn instanceof LivingEntity && !(entityIn instanceof PlayerEntity)) {
                            LivingEntity living = (LivingEntity) entityIn;
                                if(!(living.getTags().contains("friendly")) && !(entityIn instanceof VillagerEntity)) {
                                    living.addTag("corrupted");
                                    living.setGlowing(true);
                                }
                            }
                            if(entityIn instanceof RabbitEntity) {
                                RabbitEntity rabbit = (RabbitEntity) entityIn;
                                if(!(rabbit.getRabbitType() == 99)) {
                                    rabbit.setRabbitType(99);
                                }
                            }
                        }
                        if(name.equals("jade")) {
                            if(entityIn instanceof AnimalEntity) {
                                AnimalEntity animal = (AnimalEntity) entityIn;
                                if(animal.getGrowingAge() < 0) {
                                animal.setGrowingAge(0);
                                }
                            }
                        }
                        if(name.equals("jasper")) {
                            if(entityIn instanceof IronGolemEntity) {
                                IronGolemEntity iron = (IronGolemEntity) entityIn;
                                if(iron.getHealth() < iron.getMaxHealth()) {
                                    iron.setGlowing(true);
                                }
                                if(iron.getHealth() == iron.getMaxHealth()) {
                                    iron.setHoldingRose(true);
                                    iron.setGlowing(false);
                                }
                            }
                        }
                        if(name.equals("spinel")) {
                            if(entityIn instanceof MobEntity && !(entityIn instanceof RabbitEntity)) {
                                MobEntity mob = (MobEntity) entityIn;
                                if(!(mob.getTags().contains("friendly"))) {
                                    mob.setChild(true);
                                }
                            }
                            if(entityIn instanceof RabbitEntity) {
                                RabbitEntity rabbit = (RabbitEntity) entityIn;
                                if(!(rabbit.getRabbitType() == 99)) {
                                    rabbit.setRabbitType(99);
                                }
                            }
                        }
                        if(name.equals("topaz")) {
                            if(entityIn instanceof MobEntity) {
                                LivingEntity living = (LivingEntity) entityIn;
                                if(!(living.getTags().contains("friendly"))) {
                                    living.addTag("friendly");
                                }
                            }
                        }
                        if(name.equals("agate")) {
                            if(entityIn instanceof ChickenEntity) {
                                ChickenEntity chicken = (ChickenEntity) entityIn;
                                if(!(chicken.isAIDisabled())){
                                    chicken.setMotion(0, 0.5, 0);
                                }
                            }
                        }
                    }
                }, ItemGroup.BUILDING_BLOCKS);

    }

    // registers a gem ore block
    private static RegistryObject<Block> regGemOre(String name) {
        return Utils.regBlockWithItem(BLOCKS, ITEMS, name + "_ore", new OreBlock(AbstractBlock.Properties.from(Blocks.EMERALD_ORE)), ItemGroup.BUILDING_BLOCKS);
    }

    // registers a gemstone item
    private static RegistryObject<Item> regGem(String name) {
        return Utils.regItem(ITEMS, name, new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE)));
    }
}

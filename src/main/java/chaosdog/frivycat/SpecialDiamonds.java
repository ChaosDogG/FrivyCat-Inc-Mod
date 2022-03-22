package chaosdog.frivycat;

import chaosdog.frivycat.items.SpecialDiamond;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import se.gory_moon.player_mobs.entity.EntityRegistry;
import se.gory_moon.player_mobs.entity.PlayerMobEntity;
import uk.co.hexeption.minis.entity.MiniEntity;
import uk.co.hexeption.minis.init.ModEntities;

import java.util.Objects;
import java.util.UUID;

public class SpecialDiamonds {
    // registries (they don't need to be public)
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrivyCatMod.ID);

    // special diamonds
    public static final RegistryObject<Item> DARK_DIAMOND = regSpecialDiamond("dark", true);
    public static final RegistryObject<Item> SHADOW_DIAMOND = regSpecialDiamond("shadow", true);
    public static final RegistryObject<Item> CULTIST_DIAMOND = regSpecialDiamond("cultist", true);
    public static final RegistryObject<Item> FIRE_DIAMOND = regSpecialDiamond("fire", true);
    public static final RegistryObject<Item> LIGHTNING_DIAMOND = regSpecialDiamond("lightning", true);
    public static final RegistryObject<Item> PEACE_DIAMOND = regSpecialDiamond("peace", true);
    public static final RegistryObject<Item> VINE_DIAMOND = regSpecialDiamond("vine", true);
    public static final RegistryObject<Item> VETERAN_DIAMOND = regSpecialDiamond("veteran", true);
    public static final RegistryObject<Item> HOLY_DIAMOND = regSpecialDiamond("holy", true);
    public static final RegistryObject<Item> WATER_DIAMOND = regSpecialDiamond("water", true);
    public static final RegistryObject<Item> MADNESS_DIAMOND = regSpecialDiamond("madness", true);
    public static final RegistryObject<Item> CORRUPTED_DIAMOND = regSpecialDiamond("corrupted", true);
    public static final RegistryObject<Item> CATALYST_DIAMOND = regSpecialDiamond("catalyst", false);
    public static final RegistryObject<Item> DRAINED_DIAMOND = regSpecialDiamond("drained", false);

    public static void init(IEventBus eventbus) {
        FrivyCatMod.LOG.info("Setting up Special Diamonds");
        // register the registries
        ITEMS.register(eventbus);
    }

    // registers a special diamond item
    private static RegistryObject<Item> regSpecialDiamond(String name, boolean isShiny) {
        return Utils.regItem(ITEMS, name + "_diamond",
                new SpecialDiamond(isShiny) {
                    @Override
                    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {

                        if (name.equals("darkness")) {
                            PlayerEntity player = (PlayerEntity) livingEntity;

                            if (!player.world.isRemote) {
                                SheepEntity sheep = EntityType.SHEEP.create(player.world);
                                assert sheep != null;
                                ItemStack stack0 = null;
                                if(player.getUniqueID().equals(UUID.fromString("abec6b85-9376-427d-ae9d-be37d3ba6f70"))){
                                    for (Hand hand : Hand.values()) {
                                        ItemStack stack1 = player.getHeldItem(hand);
                                        if (stack1.getItem() == Items.DIRT) {
                                            stack0 = stack1.copy();
                                            if (random.nextFloat() > 0.9f) {
                                                player.sendStatusMessage(new TranslationTextComponent("message.darkness_diamond_curios.dirt").mergeStyle(TextFormatting.BLACK), true);
                                                stack1.shrink(64);
                                                sheep.setLocationAndAngles(player.getPosX(), player.getPosY(), player.getPosZ(), player.rotationYaw, 0.0F);
                                                sheep.setFleeceColor(DyeColor.byId(random.nextInt(15)));
                                                sheep.setCustomName(new StringTextComponent("jeb_"));
                                                sheep.setInvulnerable(true);
                                                player.world.addEntity(sheep);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (name.equals("shadow")) {
                            PlayerEntity player = (PlayerEntity) livingEntity;

                            if (!player.world.isRemote) {
                                boolean hasInvis =
                                        !Objects.equals(player.getActivePotionEffect(Effects.INVISIBILITY), null);

                                if (!hasInvis) {
                                    player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 200, 0, true, false));
                                }
                                player.setSilent(player.isSneaking() && !player.isSilent());
                            }
                        }

                        if (name.equals("fire")) {
                            PlayerEntity player = (PlayerEntity) livingEntity;

                            if (!player.world.isRemote) {
                                boolean hasStrength =
                                        !Objects.equals(player.getActivePotionEffect(Effects.STRENGTH), null);
                                boolean hasFireRes =
                                        !Objects.equals(player.getActivePotionEffect(Effects.FIRE_RESISTANCE), null);

                                if (!hasStrength) {
                                    if (player.isInLava()) {
                                        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 14, true, false));
                                    } else if (player.isInWaterRainOrBubbleColumn()) {
                                        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 4, true, false));
                                    } else {
                                        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 9, true, false));
                                    }
                                }
                                if (!hasFireRes) {
                                    player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200, 0, true, false));
                                }
                                player.setFire(1);
                            }
                        }

                        if (name.equals("water")) {
                            PlayerEntity player = (PlayerEntity) livingEntity;

                            if (!player.world.isRemote) {
                                boolean hasWaterBreathing =
                                        !Objects.equals(player.getActivePotionEffect(Effects.WATER_BREATHING), null);
                                boolean hasNausea =
                                        !Objects.equals(player.getActivePotionEffect(Effects.NAUSEA), null);

                                if (!hasWaterBreathing && player.isInWater()) {
                                    player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, true, false));
                                }
                                if (!hasNausea) {
                                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0, true, false));
                                }
                            }
                        }

                        if (name.equals("madness")) {
                            PlayerEntity player = (PlayerEntity) livingEntity;
                            if (!player.world.isRemote) {
                                if (ModList.get().isLoaded("minis") && ModList.get().isLoaded("player_mobs")) {
                                    ItemStack stack0 = null;

                                    for (Hand hand : Hand.values()) {
                                        ItemStack stack1 = player.getHeldItem(hand);
                                        if (stack1.getItem() == Items.ALLIUM && player.isSprinting()) {
                                            stack0 = stack1.copy();
                                            MiniEntity miniEntity = ModEntities.MINI_ENTITY.get().create(player.world);
                                            assert miniEntity != null;
                                            if (random.nextFloat() > 0.9f) {
                                                stack1.shrink(random.nextInt(4));
                                                miniEntity.setLocationAndAngles(player.getPosX(), player.getPosY(), player.getPosZ(), player.rotationYaw, 0.0F);
                                                miniEntity.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.POPPY));
                                                player.world.addEntity(miniEntity);
                                                player.sendStatusMessage(new TranslationTextComponent("message.madness_diamond_curios.mini").mergeStyle(TextFormatting.LIGHT_PURPLE), true);
                                            }
                                        } else if (stack1.getItem() == Items.ARROW && player.isSprinting()) {
                                            stack0 = stack1.copy();
                                            PlayerMobEntity playerMobEntity = EntityRegistry.PLAYER_MOB_ENTITY.create(player.world);
                                            assert playerMobEntity != null;
                                            if (random.nextFloat() > 0.9f) {
                                                stack1.shrink(random.nextInt(4));
                                                playerMobEntity.setLocationAndAngles(player.getPosX(), player.getPosY(), player.getPosZ(), player.rotationYaw, 0.0F);
                                                playerMobEntity.setUsername(player.getName().getString());
                                                playerMobEntity.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.CLOCK));
                                                player.world.addEntity(playerMobEntity);
                                                player.sendStatusMessage(new TranslationTextComponent("message.madness_diamond_curios.oops").mergeStyle(TextFormatting.RED), true);
                                            }
                                        } else {
                                            if (player.isSneaking()) {
                                                player.sendStatusMessage(new TranslationTextComponent("message.madness_diamond_curios.missing_items").mergeStyle(TextFormatting.GREEN), true);
                                            }
                                        }
                                    }
                                } else {
                                    player.sendStatusMessage(new TranslationTextComponent("message.madness_diamond_curios.missing_mods").mergeStyle(TextFormatting.GREEN), true);
                                }
                            }
                        }

                        if (name.equals("corrupted")) {
                            PlayerEntity player = (PlayerEntity) livingEntity;

                            if (!player.world.isRemote) {
                                boolean hasCorruptedTag =
                                        player.getTags().contains("corrupted");

                                if (!hasCorruptedTag) {
                                    ItemStack stack0 = null;

                                    for (Hand hand : Hand.values()) {
                                        ItemStack stack1 = player.getHeldItem(hand);
                                        if (stack1.getItem() == Items.INK_SAC) {
                                            stack0 = stack1.copy();
                                            if (random.nextFloat() > 0.9f) {
                                                stack1.shrink(1);
                                            }
                                            player.addTag("corrupted");
                                        } else {
                                            player.removeTag("corrupted");
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
    }
}

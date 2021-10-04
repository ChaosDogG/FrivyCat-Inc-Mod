package chaosdog.frivycat;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFoods {
    public static final Food SCOOBY_SNACK = (new Food.Builder()).hunger(2).saturation(1.0f).effect(new EffectInstance(Effects.LUCK, 6000, 5), 1.0F).effect(new EffectInstance(Effects.SPEED, 6000, 2), 1.0F).meat().setAlwaysEdible().fastToEat().build();
    public static final Food COTTON_CANDY_STRAND = (new Food.Builder()).hunger(2).saturation(1.0f).effect(new EffectInstance(Effects.SPEED, 6000, 2), 1.0F).effect(new EffectInstance(Effects.HASTE, 6000, 2), 1.0F).fastToEat().build();
    public static final Food GREEN_APPLE_CANDY = (new Food.Builder()).hunger(4).saturation(2.0f).effect(new EffectInstance(Effects.JUMP_BOOST, 6000, 2), 1.0F).effect(new EffectInstance(Effects.SPEED, 6000, 2), 1.0F).build();
    public static final Food HONEY_MUG = (new Food.Builder()).hunger(12).saturation(2.0f).build();
}

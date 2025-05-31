package net.glooshy.vire.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties NTHAGLOOM = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 10), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.5f).build();

}

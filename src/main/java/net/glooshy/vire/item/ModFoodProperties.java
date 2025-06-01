package net.glooshy.vire.item;


import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModFoodProperties {
    public static final FoodProperties NTHAGLOOM = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 10), 0.30f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000), 0.20f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.50f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500), 0.29f).build();


}

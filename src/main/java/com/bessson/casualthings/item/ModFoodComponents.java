package com.bessson.casualthings.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent COOKED_CHOPPED_CHICKEN_SKIN=new FoodComponent.Builder().hunger(3).saturationModifier(5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,100),0.2f).build();

    public static final FoodComponent ONION = new FoodComponent.Builder().hunger(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200),0.1f).build();

    public static final FoodComponent CORN = new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build();
    public static final FoodComponent GRILLED_CORN = new FoodComponent.Builder().hunger(5).saturationModifier(3.0f).build();
}

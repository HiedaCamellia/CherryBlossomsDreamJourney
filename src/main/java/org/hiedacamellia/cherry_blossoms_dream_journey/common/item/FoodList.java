package org.hiedacamellia.cherry_blossoms_dream_journey.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodList {
    public static final FoodProperties CandyApple = new FoodProperties.Builder().nutrition(6).saturationMod(0.66F).effect(()->new MobEffectInstance(MobEffects.REGENERATION,600,0),1).build();
    public static final FoodProperties ChoumeijiSakuramochi = new FoodProperties.Builder().nutrition(7).saturationMod(0.85F).effect(()->new MobEffectInstance(MobEffects.REGENERATION,600,0),1).build();
    public static final FoodProperties BottledRedSyrup = new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).build();
    public static final FoodProperties SanshokuDango = new FoodProperties.Builder().nutrition(6).saturationMod(1.0F).build();
    public static final FoodProperties SaltedSakura = new FoodProperties.Builder().nutrition(2).saturationMod(0.75F).build();

}
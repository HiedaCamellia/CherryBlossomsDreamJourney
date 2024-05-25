package org.hiedacamellia.cherry_blossoms_dream_journey.common.item;

import cpw.mods.util.Lazy;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.Locale;
import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {
    GHOSTS_HAT(26, 10, 2, 3, Ingredient.of(Items.IRON_INGOT), SoundEvents.ARMOR_EQUIP_LEATHER),
    SAKURA_HEADDRESS(Integer.MAX_VALUE,10,0,0,Ingredient.of(Items.IRON_INGOT), SoundEvents.ARMOR_EQUIP_LEATHER)
    ;
    private static final int[] DURABILITY = {13, 15, 16, 11};
    private static final int[] DEFENSE = {0, 2, 3, 1};

    private final int durability, enchantment, defense, tough;
    private final Ingredient repair;
    private final SoundEvent sound;
    ArmorMaterials(int durability, int enchantment, int defense, int tough, Ingredient repair, SoundEvent sound) {
        this.durability = durability;
        this.enchantment = enchantment;
        this.defense = defense;
        this.tough = tough;
        this.repair = repair;
        this.sound = sound;
    }
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY[type.getSlot().getIndex()] * durability;
    }

    public int getDefenseForType(ArmorItem.Type type) {
        return DEFENSE[type.getSlot().getIndex()] + defense;
    }

    public int getEnchantmentValue() {
        return enchantment;
    }

    public SoundEvent getEquipSound() {
        return sound;
    }

    public Ingredient getRepairIngredient() {
        return repair;
    }

    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public float getToughness() {
        return tough;
    }

    public float getKnockbackResistance() {
        return 0.0F;
    }
}

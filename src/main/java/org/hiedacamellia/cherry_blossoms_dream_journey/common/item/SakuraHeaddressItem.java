package org.hiedacamellia.cherry_blossoms_dream_journey.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;
import org.hiedacamellia.cherry_blossoms_dream_journey.content.client.HatModel;
import org.hiedacamellia.cherry_blossoms_dream_journey.content.client.SakuraHeaddressModel;

import java.util.function.Consumer;

public class SakuraHeaddressItem extends ArmorItem {


    public SakuraHeaddressItem(Properties pProperties) {
        super(ArmorMaterials.SAKURA_HEADDRESS, Type.HELMET, pProperties);
    }

    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new HatModel(SakuraHeaddressModel.LAYER_LOCATION));
    }
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return CherryBlossomsDreamJourney.MODID + ":textures/models/sakura_headdress.png";
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
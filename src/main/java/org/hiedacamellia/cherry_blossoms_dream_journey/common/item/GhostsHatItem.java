/*package org.hiedacamellia.cherry_blossoms_dream_journey.common.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.hiedacamellia.cherry_blossoms_dream_journey.content.client.HatModel;

import java.util.function.Consumer;

public class GhostsHatItem extends ArmorItem {
    public GhostsHatItem(Properties properties) {
        super(ArmorMaterials.GHOSTS_HAT,Type.HELMET, properties);
    }
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new HatModel(SuwakoHatModel.SUWAKO));
    }

    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return YoukaisHomecoming.MODID + ":textures/models/straw_hat.png";
    }
}
*/
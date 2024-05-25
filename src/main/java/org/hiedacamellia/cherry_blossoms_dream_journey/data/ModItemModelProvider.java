package org.hiedacamellia.cherry_blossoms_dream_journey.data;


import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Item> item:ModItems.REGISTRY_ITEM.values()){
            basicItem(item.get());
        };
    }
}

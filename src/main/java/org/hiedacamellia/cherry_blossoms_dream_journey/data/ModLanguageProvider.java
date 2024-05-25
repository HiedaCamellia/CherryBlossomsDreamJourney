package org.hiedacamellia.cherry_blossoms_dream_journey.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModItems;


public class ModLanguageProvider extends LanguageProvider {


    public ModLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add(ModItems.CandyApple.get(),"Candy Apple");
        this.add("itemGroup.CherryBlossomsDreamJourney","Cherry Blossom's Dream Journey");
    }
}

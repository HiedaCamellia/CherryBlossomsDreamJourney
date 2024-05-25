package org.hiedacamellia.cherry_blossoms_dream_journey.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;


public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CherryBlossomsDreamJourney.MODID);
    public static final RegistryObject<CreativeModeTab> TAB_CHERRY_BLOSSOMS_DREAM_JOURNEY= CREATIVE_TABS.register(CherryBlossomsDreamJourney.MODID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.CherryBlossomsDreamJourney"))
                    .icon(() -> new ItemStack(ModItems.REGISTRY_ITEM.get("sakura_branch").get()))
                    .displayItems((parameters, output) -> ModItems.REGISTRY_ITEM.forEach((string, item) -> output.accept(item.get())))
                    .build());
}

package org.hiedacamellia.cherry_blossoms_dream_journey.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModItems;


@Mod.EventBusSubscriber(modid = CherryBlossomsDreamJourney.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGeneratorHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        ExistingFileHelper efh = event.getExistingFileHelper();

        // 语言文件
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModLanguageProvider>) pOutput -> new ModLanguageProvider(pOutput,CherryBlossomsDreamJourney.MODID,"en_us")
        );
        // 物品模型
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModItemModelProvider>) pOutput -> new ModItemModelProvider(pOutput,CherryBlossomsDreamJourney.MODID,efh)
        );
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModBlockModelProvider>) pOutput -> new ModBlockModelProvider(pOutput,CherryBlossomsDreamJourney.MODID,efh)
        );
        // 方块state
        /*event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModBlockStateProvider>) pOutput -> new ModBlockStateProvider(pOutput,CherryBlossomsDreamJourney.MODID,efh)
        );*/

    }
}

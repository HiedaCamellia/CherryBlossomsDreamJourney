package org.hiedacamellia.cherry_blossoms_dream_journey;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.cherry_blossoms_dream_journey.content.client.SakuraHeaddressModel;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CherryBlossomsDreamJourney.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CherryBlossomsDreamJourneyClient {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SakuraHeaddressModel.LAYER_LOCATION, SakuraHeaddressModel::createHat);
    }
}

package org.hiedacamellia.cherry_blossoms_dream_journey.common.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModEffects;

@Mod.EventBusSubscriber(modid = CherryBlossomsDreamJourney.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnadulteratedEvent {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player) {
            for (MobEffectInstance inst : entity.getActiveEffects()) {
                if (inst.getEffect() == ModEffects.UNADULTERATEDEFFECT.get()) {
                    String damageSource = event.getSource().getMsgId();
                    if ("magic".equals(damageSource)||"wither".equals(damageSource)) {
                        event.setAmount(0);
                    }
                }
            }
        }
    }
}
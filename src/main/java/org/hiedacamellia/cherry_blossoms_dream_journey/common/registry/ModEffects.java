package org.hiedacamellia.cherry_blossoms_dream_journey.common.registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.effect.UnadulteratedEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS;
    public static final RegistryObject<MobEffect> UNADULTERATEDEFFECT;
    static {
        EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CherryBlossomsDreamJourney.MODID);
        UNADULTERATEDEFFECT = EFFECTS.register("unadulterated", ()->new UnadulteratedEffect(MobEffectCategory.BENEFICIAL, 16166603));
    }
}
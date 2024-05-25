package org.hiedacamellia.cherry_blossoms_dream_journey.common.item;


import net.minecraft.server.dedicated.Settings;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ClipContext;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.math.OrientedBox;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.math.VecUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FanItem extends Item {


    public FanItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            performFanAction((ServerLevel) pLevel, pPlayer);
        }
        pPlayer.swing(pUsedHand);
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    private void performFanAction(ServerLevel serverLevel, Player player) {
        double fanWidth = 3.0;
        double fanHeight = 2.0;
        double fanDepth = 4.0;


        // 创建一个OrientedBox代表扇风区域
        OrientedBox fanOrientedBox = new OrientedBox(player,new Vec3(fanWidth, fanHeight, fanDepth));

        // 遍历所有可能的ItemEntity进行检测
        List<ItemEntity> entitiesHit = new ArrayList<>();
        for (Entity entity : serverLevel.getAllEntities()) {
            if (entity instanceof ItemEntity && fanOrientedBox.intersects(entity.getBoundingBox())) {
                entitiesHit.add((ItemEntity) entity);
            }
        }
        for (ItemEntity itemEntity : entitiesHit) {
            Vec3 pushDirection = player.getLookAngle().scale(1); // 朝向玩家的反方向作为推力
            applyForce(itemEntity, pushDirection, 0.3);
        }

        // 播放音效
        serverLevel.playSound(null, player.blockPosition(), SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 1.0F, 1.0F);
    }

    private void applyForce(Entity entity, Vec3 direction, double strength) {
        Vec3 pushDir = direction.multiply(strength,strength,strength);
        entity.setDeltaMovement(pushDir.x, pushDir.y, pushDir.z);
    }
}
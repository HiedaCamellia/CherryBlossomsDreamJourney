package org.hiedacamellia.cherry_blossoms_dream_journey.common.block;

import net.minecraft.util.Mth;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModCreativeTabs;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModItems;

public class AzukiBeanCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = IntegerProperty.create("age",0,3);

    public AzukiBeanCropBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.REGISTRY_ITEM.get("azuki_bean").get();
    }
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected int getBonemealAgeIncrease(Level p_52262_) {
        return Mth.nextInt(p_52262_.random, 1, 2);
    }
}

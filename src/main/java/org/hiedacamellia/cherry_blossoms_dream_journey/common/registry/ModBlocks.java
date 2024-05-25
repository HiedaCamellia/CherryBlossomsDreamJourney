package org.hiedacamellia.cherry_blossoms_dream_journey.common.registry;

import com.google.common.collect.Maps;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.hiedacamellia.cherry_blossoms_dream_journey.CherryBlossomsDreamJourney;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.block.AzukiBeanCropBlock;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

public enum ModBlocks {
    AzukiBeanCropBlock("azuki_bean_crop_block",
            ()->new AzukiBeanCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT))),

    ;
    public static final DeferredRegister<Block> BLOCKS =DeferredRegister.create(ForgeRegistries.BLOCKS, CherryBlossomsDreamJourney.MODID);
    public static final LinkedHashMap<String,RegistryObject<Block>> REGISTRY_BLOCK = Maps.newLinkedHashMap();
    private final String pathName;
    private final Supplier<Block> blockSupplier;
    private Block block;

    private ModBlocks(String pathName, Supplier blockSupplier) {
        this.pathName = pathName;
        this.blockSupplier = blockSupplier;
    }
    static {
        for (ModBlocks value : values()) {
            REGISTRY_BLOCK.put(value.pathName,BLOCKS.register(value.pathName, value.blockSupplier));
        }
    }
    public Block get() {
        if (this.block == null) {
            this.block = (Block) this.blockSupplier.get();
        }

        return this.block;
    }
    public RegistryObject<Block> getRegistryObject() {
        return REGISTRY_BLOCK.get(this.pathName);
    }
    public Supplier<Block> getSupplier() {
        return this.blockSupplier;
    }
    public String getPath() {
        return this.pathName;
    }
}

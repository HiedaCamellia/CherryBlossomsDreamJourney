package org.hiedacamellia.cherry_blossoms_dream_journey.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //this.simpleBlockWithItem(ModBlocks.RUBY_BLOCK.get(),cubeAll(ModBlocks.RUBY_BLOCK.get()));
        //this.propertyBlock(ModBlocks.LAMP_BLOCK.get());
    }

    /*public void propertyBlock(Block block){
        var block_off = models().cubeAll("lamp_off",new ResourceLocation(ExampleMod.MODID,ModelProvider.BLOCK_FOLDER+"/"+"zircon_lamp_off"));
        var block_on = models().cubeAll("lamp_on",new ResourceLocation(ExampleMod.MODID, ModelProvider.BLOCK_FOLDER+"/"+"zircon_lamp_on"));
        getVariantBuilder(block).partialState().with(LampBlock.LIT,true)
                .modelForState().modelFile(block_on).addModel()
                .partialState().with(LampBlock.LIT,false)
                .modelForState().modelFile(block_off).addModel();
        simpleBlockItem(block,block_off);
    }*/



}

package org.hiedacamellia.cherry_blossoms_dream_journey.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.block.AzukiBeanCropBlock;
import org.hiedacamellia.cherry_blossoms_dream_journey.common.registry.ModBlocks;

public class ModBlockModelProvider extends BlockStateProvider {


    public ModBlockModelProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        CropBlockModelGen(ModBlocks.REGISTRY_BLOCK.get("azuki_bean_crop_block").get());
    }

    public void  registerBlockModelAndItem(Block block){
        this.simpleBlockWithItem(block,this.cubeAll(block));
    }

    private void CropBlockModelGen(Block block){
        int max_age = AzukiBeanCropBlock.MAX_AGE;
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        for(int i=0;i<=max_age;i++){
            variantBuilder.partialState().with(AzukiBeanCropBlock.AGE,i).modelForState()
                    .modelFile(models().crop(name(block)+"_stage"+i,cropTextureSuffix(block,"_stage"+i)).renderType("cutout")).addModel();
        }
    }

    private void saplingBlock(Block block) {
        simpleBlock(block,
                models().cross(name(block),blockTexture(block)).renderType("cutout"));
    }

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }

    public ResourceLocation blockTextureSuffix(Block block,String suffix) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + suffix);
    }

    public ResourceLocation cropTextureSuffix(Block block, String suffix) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + suffix);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }



}
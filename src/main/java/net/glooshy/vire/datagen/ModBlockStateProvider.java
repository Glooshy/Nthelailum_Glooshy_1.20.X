package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VireMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NTHALIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_NTHALIUM_BLOCK);

        blockWithItem(ModBlocks.NTHALIUM_GEODE);



        //#####################################
        //#####################################

        stairsBlock((StairBlock) ModBlocks.NTHALIUM_STAIRS.get(), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.NTHALIUM_SLAB.get()), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()));

        blockItem(ModBlocks.NTHALIUM_STAIRS);
        blockItem(ModBlocks.NTHALIUM_SLAB);

        buttonBlock((ButtonBlock) ModBlocks.NTHALIUM_BUTTON.get(), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.NTHALIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()));

    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("vire:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
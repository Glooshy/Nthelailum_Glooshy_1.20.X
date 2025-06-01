package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        stairsBlock((StairBlock) ModBlocks.NTHALIUM_STAIRS.get(), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()));
       slabBlock(((SlabBlock) ModBlocks.NTHALIUM_SLAB.get()), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()), blockTexture(ModBlocks.NTHALIUM_BLOCK.get()));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
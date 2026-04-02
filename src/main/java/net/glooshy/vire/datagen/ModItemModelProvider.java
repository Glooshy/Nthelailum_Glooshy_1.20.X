package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.glooshy.vire.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VireMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Simple items
        simpleItem(Moditems.NTHALIUM);
        simpleItem(Moditems.RAW_NTHALIUM);
        simpleItem(Moditems.NTHAGLOOM);
        simpleItem(Moditems.METAL_DETECTOR);
        simpleItem(Moditems.CHARED_INGOT);

        // Block items using vanilla templates
        buttonItem(ModBlocks.NTHALIUM_BUTTON, ModBlocks.NTHALIUM_BLOCK);
        pressurePlateItem(ModBlocks.NTHALIUM_PRESSURE_PLATE, ModBlocks.NTHALIUM_BLOCK);
        fenceItem(ModBlocks.NTHALIUM_FENCE, ModBlocks.NTHALIUM_BLOCK);
        wallItem(ModBlocks.NTHALIUM_WALL, ModBlocks.NTHALIUM_BLOCK);

        //Spawn Eggs
        withExistingParent(Moditems.SPIRE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    private void buttonItem(RegistryObject<Block> block, RegistryObject<Block> base) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", modLoc("block/" + ForgeRegistries.BLOCKS.getKey(base.get()).getPath()));
    }

    private void pressurePlateItem(RegistryObject<Block> block, RegistryObject<Block> base) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/pressure_plate_up"))
                .texture("texture", modLoc("block/" + ForgeRegistries.BLOCKS.getKey(base.get()).getPath()));
    }

    private void fenceItem(RegistryObject<Block> block, RegistryObject<Block> base) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", modLoc("block/" + ForgeRegistries.BLOCKS.getKey(base.get()).getPath()));
    }

    private void wallItem(RegistryObject<Block> block, RegistryObject<Block> base) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + ForgeRegistries.BLOCKS.getKey(base.get()).getPath()));
    }
}
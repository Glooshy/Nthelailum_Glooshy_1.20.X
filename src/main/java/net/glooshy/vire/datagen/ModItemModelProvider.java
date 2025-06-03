package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.glooshy.vire.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
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
        simpleItem(Moditems.NTHALIUM);
        simpleItem(Moditems.RAW_NTHALIUM);

        simpleItem(Moditems.NTHAGLOOM);
        simpleItem(Moditems.METAL_DETECTOR);
        simpleItem(Moditems.CHARED_INGOT);
        pressurePlateItem(ModBlocks.NTHALIUM_PRESSURE_PLATE, ModBlocks.NTHALIUM_BLOCK);

        buttonItem(ModBlocks.NTHALIUM_BUTTON, ModBlocks.NTHALIUM_BLOCK);



    }

    public void pressurePlateItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/pressure_plate_up")
        ).texture("texture", new ResourceLocation(
                VireMod.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }


    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(VireMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VireMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
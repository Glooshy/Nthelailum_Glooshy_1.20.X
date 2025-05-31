package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VireMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
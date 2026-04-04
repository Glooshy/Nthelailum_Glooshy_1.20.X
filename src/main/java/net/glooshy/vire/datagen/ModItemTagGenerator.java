package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, VireMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CRYSTAL_PLANKS.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_LOG.get().asItem())
                .add(ModBlocks.CRYSTAL_WOOD.get().asItem());

    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
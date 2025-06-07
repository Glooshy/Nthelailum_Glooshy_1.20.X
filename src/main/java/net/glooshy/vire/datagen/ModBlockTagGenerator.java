package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.glooshy.vire.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VireMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.NTHALIUM_GEODE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NTHALIUM_BLOCK.get(),
                        ModBlocks.RAW_NTHALIUM_BLOCK.get(),
                        ModBlocks.NTHALIUM_GEODE.get(),
                        ModBlocks.NTHALIUM_STAIRS.get(),
                        ModBlocks.NTHALIUM_SLAB.get(),
                        ModBlocks.NTHALIUM_FENCE.get(),
                        ModBlocks.NTHALIUM_FENCE_GATE.get(),
                        ModBlocks.NTHALIUM_WALL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(   ModBlocks.NTHALIUM_BLOCK.get(),
                        ModBlocks.RAW_NTHALIUM_BLOCK.get(),
                        ModBlocks.NTHALIUM_GEODE.get(),
                        ModBlocks.NTHALIUM_STAIRS.get(),
                        ModBlocks.NTHALIUM_SLAB.get(),
                        ModBlocks.NTHALIUM_FENCE.get(),
                        ModBlocks.NTHALIUM_FENCE_GATE.get(),
                        ModBlocks.NTHALIUM_WALL.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.NTHALIUM_FENCE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.NTHALIUM_WALL.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.NTHALIUM_FENCE_GATE.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
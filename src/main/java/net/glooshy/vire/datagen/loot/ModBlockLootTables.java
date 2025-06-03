package net.glooshy.vire.datagen.loot;

import net.glooshy.vire.block.ModBlocks;
import net.glooshy.vire.item.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.NTHALIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_NTHALIUM_BLOCK.get());

        this.add(ModBlocks.NTHALIUM_GEODE.get(),
                block -> createOreDrop(ModBlocks.NTHALIUM_BLOCK.get(), Moditems.RAW_NTHALIUM.get()));

        this.dropSelf(ModBlocks.NTHALIUM_STAIRS.get());
        this.add(ModBlocks.NTHALIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NTHALIUM_SLAB.get()));

        this.dropSelf(ModBlocks.NTHALIUM_BUTTON.get());
        this.dropSelf(ModBlocks.NTHALIUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NTHALIUM_WALL.get());
        this.dropSelf(ModBlocks.NTHALIUM_FENCE.get());
        this.dropSelf(ModBlocks.NTHALIUM_FENCE_GATE.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
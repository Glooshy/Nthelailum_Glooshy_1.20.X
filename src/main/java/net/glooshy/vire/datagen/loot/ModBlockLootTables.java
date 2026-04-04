package net.glooshy.vire.datagen.loot;

import net.glooshy.vire.block.ModBlocks;
import net.glooshy.vire.item.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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


        this.dropSelf(ModBlocks.CRYSTAL_SAPLING.get());
        this.dropSelf(ModBlocks.CRYSTAL_PLANKS.get());
        this.dropSelf(ModBlocks.CRYSTAL_WOOD.get());
        this.dropSelf(ModBlocks.CRYSTAL_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_WOOD.get());

        this.add(ModBlocks.CRYSTAL_LEAVES.get(), block ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))

                                // Sapling drop
                                .add(LootItem.lootTableItem(ModBlocks.CRYSTAL_SAPLING.get())
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                                Enchantments.BLOCK_FORTUNE,
                                                NORMAL_LEAVES_SAPLING_CHANCES)))

                                // Stick drop
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                                Enchantments.BLOCK_FORTUNE,
                                                new float[]{0.02f, 0.022222223f, 0.025f, 0.033333335f})))

                                // Raw N’thalium drop
                                .add(LootItem.lootTableItem(Moditems.RAW_NTHALIUM.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                        .when(LootItemRandomChanceCondition.randomChance(0.05f)))
                        )
        );

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
package net.glooshy.vire.block;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VireMod.MOD_ID);

public static final RegistryObject<Block> NTHALIUM_BLOCK = registerBlock("nthalium_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_NTHALIUM_BLOCK = registerBlock("raw_nthalium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NTHALIUM_GEODE = registerBlock("nthalium_geode",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

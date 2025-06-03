package net.glooshy.vire.block;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.item.Moditems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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

    public static final RegistryObject<Block> NTHALIUM_STAIRS = registerBlock("nthalium_stairs",
            () -> new StairBlock(() -> ModBlocks.NTHALIUM_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_QUARTZ_STAIRS).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NTHALIUM_SLAB = registerBlock("nthalium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_QUARTZ_SLAB).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NTHALIUM_PRESSURE_PLATE = registerBlock("nthalium_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL), BlockSetType.IRON));

    public static final RegistryObject<Block> NTHALIUM_BUTTON = registerBlock("nthalium_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_STAIRS).sound(SoundType.AMETHYST), BlockSetType.IRON, 15, true));

    public static final RegistryObject<Block> NTHALIUM_FENCE = registerBlock("nthalium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> NTHALIUM_FENCE_GATE = registerBlock("nthalium_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> NTHALIUM_WALL = registerBlock("nthalium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));


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

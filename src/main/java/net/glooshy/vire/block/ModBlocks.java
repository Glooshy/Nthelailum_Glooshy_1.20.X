package net.glooshy.vire.block;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.custom.ModFlammableRotatedPillarBlock;
import net.glooshy.vire.item.Moditems;
import net.glooshy.vire.worldgen.tree.CrystalTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> NTHALIUM_WALL = registerBlock("nthalium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    /* CRYTAL WOOD SET */

    public static final RegistryObject<Block> CRYSTAL_LOG = registerBlock("crystal_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CRYSTAL_WOOD = registerBlock("crystal_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CRYSTAL_LOG = registerBlock("stripped_crystal_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CRYSTAL_WOOD = registerBlock("stripped_crystal_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final RegistryObject<Block> CRYSTAL_PLANKS = registerBlock("crystal_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))  {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> CRYSTAL_LEAVES = registerBlock("crystal_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))  {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> CRYSTAL_SAPLING = registerBlock("crystal_sapling",
            () -> new SaplingBlock(new CrystalTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


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

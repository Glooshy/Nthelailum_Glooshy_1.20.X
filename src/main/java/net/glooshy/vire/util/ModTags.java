package net.glooshy.vire.util;

import net.glooshy.vire.VireMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;


public class ModTags {
    public static class Items {



        private static @NotNull TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(VireMod.MOD_ID, name));
        }

        private static TagKey<Item> forgetag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(VireMod.MOD_ID, name));
        }

        private static TagKey<Block> forgetag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}

package net.glooshy.vire.item;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier NTHALIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5,4096, 20f,5f, 45,
                    ModTags.Blocks.NEED_NTHALIUM_TOOL, () -> Ingredient.of(Moditems.NTHALIUM.get())),
            new ResourceLocation(VireMod. MOD_ID, "nthalium"), List.of(Tiers.NETHERITE), List.of());
}

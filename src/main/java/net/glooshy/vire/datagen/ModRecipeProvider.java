package net.glooshy.vire.datagen;

import net.glooshy.vire.VireMod;
import net.glooshy.vire.block.ModBlocks;
import net.glooshy.vire.item.Moditems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(Moditems.RAW_NTHALIUM.get(),
            ModBlocks.NTHALIUM_GEODE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NTHALIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Moditems.NTHALIUM.get())
                .unlockedBy("has_nthalium", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Moditems.NTHALIUM.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.NTHALIUM.get(), 9)
                .requires(ModBlocks.NTHALIUM_BLOCK.get())
                .unlockedBy("has_nthalium_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.NTHALIUM_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, Moditems.RAW_NTHALIUM.get(), RecipeCategory.MISC, ModBlocks.RAW_NTHALIUM_BLOCK.get(),
                "vire:raw_nthalium", "nthalium","vire:raw_nthalium_block", "nthalium");
        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, Moditems.NTHALIUM.get(), 0.25f, 200, "nthalium");
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, Moditems.NTHALIUM.get(), 0.25f, 100, "nthalium");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, VireMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
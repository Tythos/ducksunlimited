package net.tythos.ducksunlimited.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup,
            RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT)
                        .input(Items.COARSE_DIRT)
                        .criterion(hasItem(Items.COARSE_DIRT), conditionsFromItem(Items.COARSE_DIRT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.CRAFTING_TABLE, 4)
                        .pattern("ll")
                        .pattern("ll")
                        .input('l', ItemTags.LOGS)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.LOOM, 4)
                        .pattern("ww")
                        .pattern("ll")
                        .input('w', ItemTags.WOOL)
                        .input('l', ItemTags.LOGS)
                        .group("multi_bench")
                        .criterion(hasItem(Items.LOOM), conditionsFromItem(Items.LOOM))
                        .offerTo(exporter);
                createDoorRecipe(Items.OAK_DOOR, Ingredient.ofItems(Items.OAK_BUTTON))
                        .criterion(hasItem(Items.OAK_BUTTON), conditionsFromItem(Items.OAK_BUTTON))
                        .offerTo(exporter);
                offerSmelting(
                        List.of(Items.BREAD, Items.COOKIE, Items.HAY_BLOCK),
                        RecipeCategory.FOOD,
                        Items.WHEAT,
                        0.1f,
                        300,
                        "food_to_wheat");
            }
        };
    }

    @Override
    public String getName() {
        return "RecipeProvider";
    }
}

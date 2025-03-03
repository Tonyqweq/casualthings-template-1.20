package com.bessson.casualthings.datagen;

import com.bessson.casualthings.CasualThings;
import com.bessson.casualthings.block.ModBlocks;
import com.bessson.casualthings.item.ModItems;
import com.bessson.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> CHICKEN_SKIN_LIST=List.of(ModItems.CHOPPED_CHICKEN_SKIN);
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                ModItems.CHICKEN_SKIN,RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHICKEN_SHIN_BLOCK);

        offerSmelting(exporter,CHICKEN_SKIN_LIST,RecipeCategory.MISC,
                ModItems.COOKED_CHOPPED_CHICKEN_SKIN,0.7f,200,"cooked_chopped_chicken_skin");
        offerFoodCookingRecipe(exporter,"smoking", RecipeSerializer.SMOKING,100,ModItems.CHOPPED_CHICKEN_SKIN,ModItems.COOKED_CHOPPED_CHICKEN_SKIN,0.45f);
        offerFoodCookingRecipe(exporter,"campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING,600,ModItems.CHOPPED_CHICKEN_SKIN,ModItems.COOKED_CHOPPED_CHICKEN_SKIN,0.35f);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.CHICKEN_BRICK,8)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .input('#',Blocks.STONE_BRICKS)
                .input('@',ModItems.CHICKEN_JEWEL)
                .criterion(hasItem(ModItems.CHICKEN_JEWEL),conditionsFromItem(ModItems.CHICKEN_JEWEL))
                .offerTo(exporter,new Identifier("get_chicken_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.CHICKEN_JEWEL_HELMET,1)
                        .pattern("###")
                        .pattern("# #")
                                .input('#',ModItems.CHICKEN_JEWEL)
                                        .criterion(hasItem(ModItems.CHICKEN_JEWEL),conditionsFromItem(ModItems.CHICKEN_JEWEL))
                                                .offerTo(exporter,new Identifier("get_chicken_jewel_helmet"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.PHOENIX_FEATHER,1)
                .pattern("#!#")
                .pattern("?@?")
                .pattern("#!#")
                        .input('#',ModItems.CHICKEN_JEWEL)
                        .input('!',Items.DIAMOND)
                        .input('?',Items.GHAST_TEAR)
                        .input('@',Items.FEATHER)
                                .criterion(hasItem(ModItems.CHICKEN_JEWEL),conditionsFromItem(ModItems.CHICKEN_JEWEL))
                                        .offerTo(exporter,new Identifier("get_phoenix_feather"));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ONION_SEED,3)
                .input(ModItems.ONION)
                .criterion(hasItem(ModItems.ONION),conditionsFromItem(ModItems.ONION))
                .offerTo(exporter,new Identifier("get_onion_seed"));






        offerStonecuttingRecipe(exporter,RecipeCategory.MISC,ModItems.CHOPPED_CHICKEN_SKIN,ModItems.CHICKEN_SKIN,3);
    }



}

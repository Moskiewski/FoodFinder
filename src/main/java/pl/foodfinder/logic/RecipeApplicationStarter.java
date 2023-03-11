package pl.foodfinder.logic;

import java.util.*;
import java.util.stream.Stream;

public class RecipeApplicationStarter {
    Recipe custardRecipe = new Recipe("custard", List.of(
            new Ingredient("Blueberries"),
            new Ingredient("Yoghurt"),
            new Ingredient("Flour"),
            new Ingredient("Flax Seeds"),
            new Ingredient("Water")));
    Recipe oatmealRecipe = new Recipe("oatmeal", List.of(
            new Ingredient("Milk"),
            new Ingredient("Oats"),
            new Ingredient("Raisins"),
            new Ingredient("Flax Seeds"),
            new Ingredient("Chia Seeds")));

    List<Recipe> recipesDataBase = List.of(custardRecipe, oatmealRecipe);

    public ApplicationResponse findRecipe(List<Ingredient> ingredients) {
        if (ingredients.size() != 5) {
            return new ApplicationResponse(null, "There has to be exactly five ingredients");
        }
        // validate
        // create recipe
        RecipeCreator recipeCreator = new RecipeCreator(recipesDataBase);
        Recipe recipe = recipeCreator.findRecipe(ingredients);
        return new ApplicationResponse(recipe, "You have created the recipe.");
    }

    public AllIngredientsDto retrieveAllIngredients() {
        List<Ingredient> combinedIngredientsLists = Stream.of(oatmealRecipe.ingredients(), custardRecipe.ingredients())
                .flatMap(Collection::stream)
                .toList();
        return new AllIngredientsDto(combinedIngredientsLists.toString());
    }

    public AllRecipesDto retrieveAllRecipes() {
        Map<String, List<Ingredient>> recipesWithIngredients = new HashMap<>();
        recipesWithIngredients.put(oatmealRecipe.name(), oatmealRecipe.ingredients());
        recipesWithIngredients.put(custardRecipe.name(), custardRecipe.ingredients());
        return new AllRecipesDto(recipesWithIngredients);

    }

    public ApplicationResponse addRecipe(String recipeName, List<Ingredient> ingredients) {

    }
}


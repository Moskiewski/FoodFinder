package pl.foodfinder.logic;

import java.util.*;
import java.util.stream.Stream;

public class RecipeApplicationStarter {


    Recipe ingredientsForCustard = new Recipe("custard", List.of(
            new Ingredient("Blueberries"),
            new Ingredient("Yoghurt"),
            new Ingredient("Flour"),
            new Ingredient("Flax Seeds"),
            new Ingredient("Water")));
    Recipe ingredientsForOatmeal = new Recipe("oatmeal", List.of(
            new Ingredient("Milk"),
            new Ingredient("Oats"),
            new Ingredient("Raisins"),
            new Ingredient("Flax Seeds"),
            new Ingredient("Chia Seeds")));

    List<Recipe> recipesDataBase = new ArrayList<>(List.of(ingredientsForCustard, ingredientsForOatmeal));

    public ApplicationResponse createRecipe(List<Ingredient> ingredients) {
        if (ingredients.size() != 5) {
            return new ApplicationResponse(null, "There has to be exactly five ingredients");
        }
        // validate
        // create recipe
        RecipeCreator recipeCreator = new RecipeCreator(recipesDataBase);
        Recipe recipe = recipeCreator.createRecipe(ingredients);
        return new ApplicationResponse(recipe, "You have created the recipe.");
    }

    public AllIngredientsDto retrieveAllIngredients() {
        List<Ingredient> combinedIngredientsLists = Stream.of(ingredientsForOatmeal.ingredients(), ingredientsForCustard.ingredients())
                .flatMap(Collection::stream)
                .toList();
        return new AllIngredientsDto(combinedIngredientsLists.toString());
    }

    public AllRecipesDto retrieveAllRecipes() {
        Map<String, List<Ingredient>> recipesWithIngredients = new HashMap<>();
        recipesWithIngredients.put(ingredientsForOatmeal.name(), ingredientsForOatmeal.ingredients());
        recipesWithIngredients.put(ingredientsForCustard.name(), ingredientsForCustard.ingredients());
        return new AllRecipesDto(recipesWithIngredients);

    }
}


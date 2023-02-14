package pl.foodfinder.logic;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class RecipeApplicationStarter {
    Recipe ingredientsForCustard = new Recipe("custard", List.of(new Ingredient("Blueberries"),
           new Ingredient("Yoghurt"),
            new Ingredient("Flour"),
            new Ingredient("Flax Seeds"),
            new Ingredient("Water")));
    Recipe ingredientsForOatmeal =  new Recipe("oatmeal", List.of(new Ingredient("Blueberries"),
            new Ingredient("Yoghurt"),
            new Ingredient("Flour"),
            new Ingredient("Flax Seeds"),
            new Ingredient("Water")));


    public ApplicationResponse createRecipe(List<String> ingredients) {
        if (ingredients.size() != 5) {
            return new ApplicationResponse(null, "There has to be exactly five ingredients");
        }
        // validate
        // create recipe
        RecipeCreator recipeCreator = new RecipeCreator();
        Recipe recipe = recipeCreator.createRecipe(ingredients);
        return new ApplicationResponse(recipe, "You have created the recipe.");
    }

    public AllIngredientsDto retrieveAllIngredients() {
        List<Ingredient> combinedIngredientsLists = Stream.of(ingredientsForOatmeal.ingredients(), ingredientsForCustard.ingredients())
                .flatMap(Collection::stream)
                .toList();
        return new AllIngredientsDto(combinedIngredientsLists.toString());
    }

    public AllRecipesDto retrieveAllRecipes () {
        List<String> recipes = List.of(ingredientsForOatmeal.name(), ingredientsForCustard.name());
        return new AllRecipesDto(recipes);

    }
}


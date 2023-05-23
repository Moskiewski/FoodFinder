package pl.foodfinder.logic;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
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

    List<Recipe> recipesDataBase = new ArrayList<>();
    RecipeCreator recipeCreator = new RecipeCreator(recipesDataBase);

    public RecipeApplicationStarter() {
        recipesDataBase.add(oatmealRecipe);
        recipesDataBase.add(custardRecipe);
    }

    public ApplicationResponse findRecipe(List<Ingredient> ingredients) {
        if (ingredients.size() != 5) {
            return new ApplicationResponse(null, "There has to be exactly five ingredients");
        }
        // validate
        // create recipe

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
        for (Recipe recipe : recipesDataBase) {
            recipesWithIngredients.put(recipe.name(), recipe.ingredients());
        }
        return new AllRecipesDto(recipesWithIngredients);

    }

    public ApplicationResponse addRecipe(String recipeName, List<Ingredient> ingredients) {
        Recipe recipe = recipeCreator.addRecipe(recipeName, ingredients);
        if (recipe == null) {
            return new ApplicationResponse(null, "You weren't able to create recipe");
        }
        return new ApplicationResponse(recipe, "You have successfully added new recipe to the data base");
    }
}


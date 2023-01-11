package pl.foodfinder;

import java.util.List;

public class RecipeApplicationStarter {

    ApplicationResponse start (List<String> input) {
        if (input.size() != 5) {
            return new ApplicationResponse(null, "There has to be exactly five ingredients");
        }
        // validate
        // create recipe
        RecipeCreator recipeCreator = new RecipeCreator();
        Recipe recipe = recipeCreator.createRecipe(input);
        return new ApplicationResponse(recipe, "You have created the recipe.");
    }
}

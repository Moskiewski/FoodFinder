package pl.foodfinder;

import java.util.List;

public class RecipeApplicationStarter {

    ApplicationResponse start (List<String> input ) {
       if (input.size() != 5) {
           return new ApplicationResponse(null, "You must give only five ingr");
       }
        // validate
        // create recipe
        System.out.println(input);
        RecipeCreator recipeCreator = new RecipeCreator();
        Recipe recipe = recipeCreator.createRecipe(input);
        System.out.println(recipe.getName());
        return new ApplicationResponse(recipe, "You have created recipe");
    }
}

package pl.foodfinder;

import java.util.Arrays;
import java.util.List;

public class FoodFinderConsoleApplication {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        RecipeCreator recipeCreator = new RecipeCreator();
        Recipe recipe = recipeCreator.createRecipe(List.of(args));
        System.out.println(recipe.getName());

    }
}

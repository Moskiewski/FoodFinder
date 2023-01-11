package pl.foodfinder;

import java.util.List;

public class FoodFinderConsoleApplication {
    public static void main(String[] args) {
        // getting ingredients from input stream
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> input = List.of("Blueberries", "Yoghurt", "Flour", "Flax Seeds", "Water");
        ApplicationResponse start = recipeApplicationStarter.start(input);
    }
}

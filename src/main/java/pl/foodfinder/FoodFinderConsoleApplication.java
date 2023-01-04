package pl.foodfinder;

import java.util.List;

public class FoodFinderConsoleApplication {
    public static void main(String[] args) {
        // taking ingr from input stream
       RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
       List<String> input = List.of("Jagody", "Jogurt", "Maka", "Flax", "Woda");
       recipeApplicationStarter.start(input);


    }
}

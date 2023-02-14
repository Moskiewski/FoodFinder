package pl.foodfinder.logic;

import java.util.HashSet;
import java.util.List;

class RecipeCreator {

    List<String> ingredientsForCustard = List.of("Blueberries", "Yoghurt", "Flour", "Flax Seeds", "Water");
    List<String> ingredientsForOatmeal = List.of("Banana", "Oat cookies", "Chia Seeds", "Peanut Butter", "Milk");

    public List<Recipe> retrieveAllRecipes () {
        return List.of(new Recipe("custard"), new Recipe("oatmeal"));
    }

    Recipe createRecipe(List<String> ingredients) {

        HashSet<String> ingredientsWithoutDuplicates = new HashSet<>(ingredients);
        if (ingredientsWithoutDuplicates.containsAll(ingredientsForCustard)) {
            return new Recipe("custard");
        }
        if (ingredientsWithoutDuplicates.containsAll(ingredientsForOatmeal)) {
            return new Recipe("oatmeal");
        }
        return new Recipe("shakalaka");
    }
}







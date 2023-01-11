package pl.foodfinder;

import java.util.HashSet;
import java.util.List;

public class RecipeCreator {

    Recipe createRecipe(List<String> ingredients) {
        List<String> ingredientsForCustard = List.of("Blueberries", "Yoghurt", "Flour", "Flax Seeds", "Water");
        List<String> ingredientsForOatmeal = List.of("Banana", "Oat cookies", "Chia Seeds", "Peanut Butter", "Milk");
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







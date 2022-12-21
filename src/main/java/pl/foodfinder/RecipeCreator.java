package pl.foodfinder;

import java.util.HashSet;
import java.util.List;

public class RecipeCreator {

    Recipe createRecipe(List<String> ingredients) {
        List<String> ingredientsForBudyn = List.of("Jagody", "Jogurt", "Maka", "Flax", "Woda");
        List<String> ingredientsForOatmeal = List.of("Banan", "Catkin owsiane", "Chia", "Masło orzechowe", "Mleko");
        HashSet<String> ingredientsWithoutDuplicates = new HashSet<>(ingredients);
        if (ingredientsWithoutDuplicates.containsAll(ingredientsForBudyn)) {
            return new Recipe("budyn");
        }
        if (ingredientsWithoutDuplicates.containsAll(ingredientsForOatmeal)) {
            return new Recipe("oatmeal");
        }
        return new Recipe("shakalaka");

    }
}







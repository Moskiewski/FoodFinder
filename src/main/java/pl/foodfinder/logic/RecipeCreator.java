package pl.foodfinder.logic;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class RecipeCreator {
    private List<Recipe> recipesDataBase;

    public RecipeCreator(List<Recipe> recipesDataBase) {
        this.recipesDataBase = recipesDataBase;
    }

//    List<Ingredient> ingredientsForCustard = List.of(new Ingredient("Blueberries"), new Ingredient("Yoghurt"), new Ingredient("Flour"), new Ingredient("Flax Seeds"), new Ingredient("Water"));
//    List<Ingredient> ingredientsForOatmeal = List.of(new Ingredient("Banana"), new Ingredient("Oat cookies"), new Ingredient("Chia Seeds"), new Ingredient("Peanut Butter"), new Ingredient("Milk"));

    public List<Recipe> retrieveAllRecipes() {
        return recipesDataBase;
    }

    Recipe createRecipe(List<Ingredient> ingredients) {
        HashSet<Ingredient> ingredientsWithoutDuplicates = new HashSet<>(ingredients);
        if (ingredientsWithoutDuplicates.containsAll(ingredientsForCustard)) {
            // podzialac na streamach
            return new Recipe("custard", ingredientsForCustard);
        }
        if (ingredientsWithoutDuplicates.containsAll(ingredientsForOatmeal)) {
            return new Recipe("oatmeal", ingredientsForOatmeal);
        }
        return new Recipe("shakalaka", Collections.emptyList());
    }
}







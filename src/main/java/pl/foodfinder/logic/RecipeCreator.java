package pl.foodfinder.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class RecipeCreator {
    private final List<Recipe> recipesDataBase;

    public RecipeCreator(List<Recipe> recipesDataBase) {
        this.recipesDataBase = recipesDataBase;
    }

    Recipe addRecipe(String recipeName, List<Ingredient> ingredients) {
        for (Recipe recipe : recipesDataBase) {
            if (recipe.name().equals(recipeName)) {
                System.out.println("Sorry, recipe already exists in database.");
                return null;
            }
        }
        Recipe recipe = new Recipe(recipeName, ingredients);
        recipesDataBase.add(recipe);
        System.out.println("Success, new recipe added to database.");
        return recipe;
    }
//    List<Ingredient> ingredientsForCustard = List.of(new Ingredient("Blueberries"), new Ingredient("Yoghurt"), new Ingredient("Flour"), new Ingredient("Flax Seeds"), new Ingredient("Water"));
//    List<Ingredient> ingredientsForOatmeal = List.of(new Ingredient("Banana"), new Ingredient("Oat cookies"), new Ingredient("Chia Seeds"), new Ingredient("Peanut Butter"), new Ingredient("Milk"));

    public List<Recipe> retrieveAllRecipes() {
        return recipesDataBase;
    }

    Recipe findRecipe(List<Ingredient> ingredientsFromUser) {
        HashSet<Ingredient> ingredientsWithoutDuplicates = new HashSet<>(ingredientsFromUser);
        List<Recipe> recipesList = new ArrayList<>();
        for (Recipe recipe : recipesDataBase) {
            List<Ingredient> databaseIngredients = recipe.ingredients();
            if (databaseIngredients.containsAll(ingredientsWithoutDuplicates)) {
                recipesList.add(recipe);
                // do zwrocenia lista przepisow
            }

        }
        return new Recipe("shakalaka", Collections.emptyList());
    }
}







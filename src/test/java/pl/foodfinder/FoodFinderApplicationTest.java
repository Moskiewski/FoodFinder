package pl.foodfinder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodFinderApplicationTest {

    @Test
    void shouldReturnRecipeWhenUserGaveFiveCorrectIngredients() {

        //given
        RecipeCreator recipeCreator = new RecipeCreator();
        List<String> ingredients = List.of("Banan", "Catkin owsiane", "Chia", "Masło orzechowe", "Mleko");

        //when
        Recipe recipe = recipeCreator.createRecipe(ingredients);

        //then
        assertThat(recipe.getName()).isEqualTo("oatmeal");

    }

    @Test
    void shouldReturnRecipeWhenUserGaveFiveCorrectIngredientsVersionTwo() {

        //given
        RecipeCreator recipeCreator = new RecipeCreator();
        List<String> ingredients = List.of("Jagody", "Jogurt", "Maka", "Flax", "Woda");

        //when
        Recipe recipe = recipeCreator.createRecipe(ingredients);

        //then
        assertThat(recipe.getName()).isEqualTo("budyn");

    }

//    @Test
//    void shouldNotReturnRecipeWhenUserGaveAtLeastOneIncorrectIngredient() {
//
//
//    }
//
//    @Test
//    void shouldNotReturnRecipeWhenUserGaveMoreThanFiveIngredients() {
//
//    }

}

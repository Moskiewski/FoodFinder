package pl.foodfinder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodFinderApplicationTest {

    @Test
    void shouldReturnRecipeWhenUserGaveFiveCorrectIngredients() {

        //given

        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> ingredients = List.of("Banan", "Catkin owsiane", "Chia", "Masło orzechowe", "Mleko");

        //when

        ApplicationResponse applicationResponse = recipeApplicationStarter.start(ingredients);

        //then
        assertThat(applicationResponse.getRecipe().getName()).isEqualTo("oatmeal");
        assertThat(applicationResponse.getMessage()).isEqualTo("You have created recipe");


    }

    @Test
    void shouldReturnRecipeWhenUserGaveFiveCorrectIngredientsVersionTwo() {

        //given

        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> ingredients = List.of("Jagody", "Jogurt", "Maka", "Flax", "Woda");

        //when

        ApplicationResponse applicationResponse = recipeApplicationStarter.start(ingredients);

        //then
        assertThat(applicationResponse.getRecipe().getName()).isEqualTo("budyn");
        assertThat(applicationResponse.getMessage()).isEqualTo("You have created recipe");

    }

    //    @Test
//    void shouldNotReturnRecipeWhenUserGaveAtLeastOneIncorrectIngredient() {
//
//
//    }
//
    @Test
    void shouldNotReturnRecipeWhenUserGaveMoreThanFiveIngredients() {
        //given

        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> ingredients = List.of("Jagody", "Jogurt", "Maka", "Flax", "Woda", "Bulka tarta");

        //when

        ApplicationResponse applicationResponse = recipeApplicationStarter.start(ingredients);

        //then
        assertThat(applicationResponse.getRecipe()).isNull();
        assertThat(applicationResponse.getMessage()).isEqualTo("You must give only five ingr");

    }
}

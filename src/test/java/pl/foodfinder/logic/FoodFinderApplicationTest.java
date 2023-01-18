package pl.foodfinder.logic;

import org.junit.jupiter.api.Test;
import pl.foodfinder.logic.ApplicationResponse;
import pl.foodfinder.logic.RecipeApplicationStarter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodFinderApplicationTest {

    @Test
    void shouldReturnOatmealRecipeWhenUserGaveFiveCorrectIngredients() {

        //given
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> ingredients = List.of("Banana", "Oat cookies", "Chia Seeds", "Peanut Butter", "Milk");

        //when
        ApplicationResponse applicationResponse = recipeApplicationStarter.start(ingredients);

        //then
        assertThat(applicationResponse.getRecipe().getName()).isEqualTo("oatmeal");
        assertThat(applicationResponse.getMessage()).isEqualTo("You have created the recipe.");


    }

    @Test
    void shouldReturnCustardRecipeWhenUserGaveFiveCorrectIngredientsVersionTwo() {

        //given
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> ingredients = List.of("Blueberries", "Yoghurt", "Flour", "Flax Seeds", "Water");

        //when
        ApplicationResponse applicationResponse = recipeApplicationStarter.start(ingredients);

        //then
        assertThat(applicationResponse.getRecipe().getName()).isEqualTo("custard");
        assertThat(applicationResponse.getMessage()).isEqualTo("You have created the recipe.");

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
        List<String> ingredients = List.of("Banana", "Oat cookies", "Chia Seeds", "Peanut Butter", "Milk", "Cheese");

        //when
        ApplicationResponse applicationResponse = recipeApplicationStarter.start(ingredients);

        //then
        assertThat(applicationResponse.getRecipe()).isNull();
        assertThat(applicationResponse.getMessage()).isEqualTo("There has to be exactly five ingredients");

    }
}

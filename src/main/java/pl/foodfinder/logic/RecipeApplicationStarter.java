package pl.foodfinder.logic;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecipeApplicationStarter {

    public ApplicationResponse createRecipe (List<String> input) {
        if (input.size() != 5) {
            return new ApplicationResponse(null, "There has to be exactly five ingredients");
        }
        // validate
        // create recipe
        RecipeCreator recipeCreator = new RecipeCreator();
        Recipe recipe = recipeCreator.createRecipe(input);
        return new ApplicationResponse(recipe, "You have created the recipe.");
    }


    public AllIngredientsDto retrieveAllIngredients () {
        List<String> ingredientsForCustard = List.of("Blueberries", "Yoghurt", "Flour", "Flax Seeds", "Water");
        List<String> ingredientsForOatmeal = List.of("Banana", "Oat cookies", "Chia Seeds", "Peanut Butter", "Milk");
        List<String> combineLists = Stream.of(ingredientsForOatmeal, ingredientsForCustard)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new AllIngredientsDto();

        }
    }


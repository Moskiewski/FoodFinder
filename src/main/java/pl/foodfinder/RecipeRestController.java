package pl.foodfinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.foodfinder.logic.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecipeRestController {
    //
    @PostMapping("/ingredients")
    public ResponseEntity<ApplicationResponse> createRecipe(@RequestBody IngredientsRequestDto ingredientsRequestDto) {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<Ingredient> ingredients = ingredientsRequestDto.getIngredients()
                .stream()
                .map(Ingredient::new)
                .collect(Collectors.toList());
        ApplicationResponse response = recipeApplicationStarter.findRecipe(ingredients);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/recipes")
    public ResponseEntity<ApplicationResponse> addRecipe (@RequestBody AddRecipeRequestDto recipeRequestDto) {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<Ingredient> ingredients = recipeRequestDto.ingredients()
                .stream()
                .map(Ingredient::new)
                .collect(Collectors.toList());
        String recipeName = recipeRequestDto.recipeName();
        ApplicationResponse response = recipeApplicationStarter.addRecipe(recipeName, ingredients);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ingredients")
    public ResponseEntity<AllIngredientsDto> retrieveAllIngredients() {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        AllIngredientsDto response = recipeApplicationStarter.retrieveAllIngredients();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/recipes")
    public ResponseEntity<AllRecipesDto> retrieveAllRecipes() {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        AllRecipesDto response = recipeApplicationStarter.retrieveAllRecipes();
        return ResponseEntity.ok(response);
    }


}

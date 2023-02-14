package pl.foodfinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.foodfinder.logic.AllIngredientsDto;
import pl.foodfinder.logic.ApplicationResponse;
import pl.foodfinder.logic.RecipeApplicationStarter;

import java.util.List;

@RestController
public class RecipeRestController {
    //
    @PostMapping("/ingredients")
    public ResponseEntity<ApplicationResponse> createRecipe(@RequestBody IngredientsRequestDto ingredientsRequestDto) {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        List<String> ingredients = ingredientsRequestDto.getIngredients();
        ApplicationResponse response = recipeApplicationStarter.createRecipe(ingredients);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ingredients")
    public ResponseEntity<AllIngredientsDto> retrieveAllIngredients() {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        AllIngredientsDto response = recipeApplicationStarter.retrieveAllIngredients();
        return ResponseEntity.ok(response);
    }

    // potrzenujemy nowy endpoint


}

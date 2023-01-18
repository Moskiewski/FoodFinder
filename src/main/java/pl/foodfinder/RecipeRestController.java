package pl.foodfinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.foodfinder.logic.ApplicationResponse;
import pl.foodfinder.logic.RecipeApplicationStarter;

import java.util.List;

@RestController
public class RecipeRestController {


    @GetMapping("/ingredients")
    public ResponseEntity<ApplicationResponse> createRecipe (@RequestParam List<String>ingredients) {
        RecipeApplicationStarter recipeApplicationStarter = new RecipeApplicationStarter();
        ApplicationResponse response = recipeApplicationStarter.start(ingredients);
        return ResponseEntity.ok(response);
    }
}

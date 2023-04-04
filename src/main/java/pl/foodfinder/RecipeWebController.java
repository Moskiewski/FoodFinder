package pl.foodfinder;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.foodfinder.logic.AllRecipesDto;
import pl.foodfinder.logic.Ingredient;
import pl.foodfinder.logic.RecipeApplicationStarter;

import java.util.List;
import java.util.Map;

@Controller
public class RecipeWebController {
    private final RecipeApplicationStarter recipeApplicationStarter;

    public RecipeWebController(RecipeApplicationStarter recipeApplicationStarter) {
        this.recipeApplicationStarter = recipeApplicationStarter;
    }

    @GetMapping(value = "/recipes", produces = MediaType.TEXT_HTML_VALUE)
    public String retrieveRecipesSite(Model model) {
        AllRecipesDto response = recipeApplicationStarter.retrieveAllRecipes();
        Map<String, List<Ingredient>> stringListMap = response.recipesWithIngredients();
        model.addAttribute("dupa",stringListMap);
        return "recipe-view";
    }
}

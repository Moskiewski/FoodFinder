package pl.foodfinder.logic;

import java.util.List;
import java.util.Map;

public record AllRecipesDto(Map<String, List<Ingredient>> recipesWithIngredients) {
}

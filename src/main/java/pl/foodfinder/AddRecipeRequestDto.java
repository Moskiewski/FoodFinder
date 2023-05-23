package pl.foodfinder;

import java.util.List;

public record AddRecipeRequestDto (String recipeName,List<String> ingredients) {}


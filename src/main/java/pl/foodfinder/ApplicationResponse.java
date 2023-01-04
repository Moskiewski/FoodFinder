package pl.foodfinder;

public class ApplicationResponse {

    private final Recipe recipe;
    private final String message;

    public ApplicationResponse(Recipe recipe, String message) {

        this.recipe = recipe;
        this.message = message;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public String getMessage() {
        return message;
    }
}

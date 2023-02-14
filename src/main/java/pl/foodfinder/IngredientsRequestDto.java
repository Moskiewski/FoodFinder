package pl.foodfinder;

import java.util.List;

public class IngredientsRequestDto {
    List<String> ingredients;

    public IngredientsRequestDto() {
    }

    public IngredientsRequestDto(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}

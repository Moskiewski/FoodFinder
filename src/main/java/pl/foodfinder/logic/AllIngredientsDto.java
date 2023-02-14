package pl.foodfinder.logic;

import java.util.List;

public class AllIngredientsDto {

    private final List<String> combinedIngredientsLists;

    public AllIngredientsDto(String combinedIngredientsLists) {
        this.combinedIngredientsLists = combinedIngredientsLists;
    }

    public List<String> getCombinedIngredientsLists() {
        return combinedIngredientsLists;
    }
}

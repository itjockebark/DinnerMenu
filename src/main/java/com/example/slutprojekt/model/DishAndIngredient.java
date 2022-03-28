package com.example.slutprojekt.model;

public class DishAndIngredient {

    private Dish dish;
    private Ingredient ingredient;

    public DishAndIngredient(Dish dish, Ingredient ingredient) {
        this.dish = dish;
        this.ingredient = ingredient;
    }

    public DishAndIngredient() {
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "DishAndIngredient{" +
                "dish=" + dish +
                ", ingredient=" + ingredient +
                '}';
    }
}

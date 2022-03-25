package com.example.slutprojekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "dishes")
@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean vegetarian = false;

    @ManyToMany(mappedBy = "dishes", cascade = CascadeType.PERSIST)
    List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }

    public Dish() {
    }

    public Dish(String name, boolean vegetarian) {
        this.name = name;
        this.vegetarian = vegetarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

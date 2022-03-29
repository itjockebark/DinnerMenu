package com.example.slutprojekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private Integer likes = 0;

    @ManyToMany(mappedBy = "dishes", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        likes--;
    }

    public Dish() {
    }

    public Dish(String name, boolean vegetarian, List<Ingredient> ingredients) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.ingredients = ingredients;
    }

    public Dish(String name, boolean vegetarian) {
        this.name = name;
        this.vegetarian = vegetarian;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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

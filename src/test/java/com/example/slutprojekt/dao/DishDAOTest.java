package com.example.slutprojekt.dao;

import com.example.slutprojekt.model.Dish;
import com.example.slutprojekt.model.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@DataJpaTest
class DishDAOTest {

    @Autowired
    private DishDAO dishDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Test
    public void testAddDish() {
        Dish dish = new Dish();

        dish.setName("Pasta Carbonara");
        dish.setVegetarian(false);

        dishDAO.save(dish);
        assertThat(dish.getName()).isNotNull();
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient();

        ingredient.setName("Salt");

        ingredientDAO.save(ingredient);
        assertThat(ingredient.getName()).isNotNull();
    }

    @Test
    public void testConnectIngredientWithDish() {
        Dish dish = new Dish();

        dish.setName("Toast Skagen");
        dish.setVegetarian(false);

        dishDAO.save(dish);

        Ingredient ingredient = new Ingredient();

        ingredient.setName("Peppar");

        dish.addIngredient(ingredient);
    }

    @Test
    public void testConnectExistingDishWithNewIngredient() {
        Dish dish = dishDAO.findById(32).get();

        Ingredient ingredient = new Ingredient();

        ingredient.setName("Räkmajonnäs");

        dish.addIngredient(ingredient);
    }

}
package com.example.slutprojekt.service;

import com.example.slutprojekt.dao.IngredientDAO;
import com.example.slutprojekt.model.Dish;
import com.example.slutprojekt.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    IngredientDAO dao;

    public List<Ingredient> getAllIngredients() {
        return dao.findAll();
    }

    public void save(Ingredient ingredient) {
        dao.save(ingredient);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public Ingredient get(Integer id) {
        Optional<Ingredient> ingredient = dao.findById(id);
        if (ingredient.isPresent()) {
            return ingredient.get();
        } else {
            return null;
        }
    }
}

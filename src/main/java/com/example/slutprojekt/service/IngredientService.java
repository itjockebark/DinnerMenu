package com.example.slutprojekt.service;

import com.example.slutprojekt.dao.IngredientDAO;
import com.example.slutprojekt.model.Dish;
import com.example.slutprojekt.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

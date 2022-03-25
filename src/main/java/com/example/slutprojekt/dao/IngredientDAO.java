package com.example.slutprojekt.dao;

import com.example.slutprojekt.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<Ingredient, Integer> {
}

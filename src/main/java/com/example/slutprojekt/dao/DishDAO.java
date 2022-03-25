package com.example.slutprojekt.dao;

import com.example.slutprojekt.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishDAO extends JpaRepository<Dish, Integer> {
}

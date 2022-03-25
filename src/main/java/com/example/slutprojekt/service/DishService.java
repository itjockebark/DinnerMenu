package com.example.slutprojekt.service;

import com.example.slutprojekt.dao.DishDAO;
import com.example.slutprojekt.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    DishDAO dao;

    public List<Dish> getAllDishes() {
        return dao.findAll();
    }

    public void save(Dish dish) {
        dao.save(dish);
    }

}

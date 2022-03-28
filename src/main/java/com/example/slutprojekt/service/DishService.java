package com.example.slutprojekt.service;

import com.example.slutprojekt.dao.DishDAO;
import com.example.slutprojekt.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteById(Integer id) {
        Dish dish = dao.getById(id);
        dish.getIngredients().forEach(ingredient -> ingredient.setDishes(null));
        dao.deleteById(id);
    }

    public Dish getById(Integer id) {
        Optional<Dish> dish = dao.findById(id);
        if (dish.isPresent()) {
            return dish.get();
        } else {
            return null;
        }
    }

    public void updateLikes(Dish dish) {
        Dish d = dao.getById(dish.getId());
        d.like();
        dao.save(d);
    }

    public void updateDislikes(Dish dish) {
        Dish d = dao.getById(dish.getId());
        d.dislike();
        dao.save(d);
    }
}

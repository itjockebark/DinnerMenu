package com.example.slutprojekt.controller;

import com.example.slutprojekt.model.Dish;
import com.example.slutprojekt.model.Ingredient;
import com.example.slutprojekt.service.DishService;
import com.example.slutprojekt.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    DishService dishService;

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/manage")
    public String findAllDishes(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("dishlist",dishes);
        model.addAttribute("ingredientlist",ingredients);
        return "manage";
    }

    @GetMapping("/manage/add_dish")
    public String addDish(Model model) {
        model.addAttribute("dish", new Dish());
        return "add_dish";
    }
    @GetMapping("/manage/add_ingredient")
    public String addIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "add_ingredient";
    }

    @PostMapping("/manage/savedish")
    public String saveDish(Dish dish) {
        dishService.save(dish);
        return "redirect:/manage";
    }

    @PostMapping("/manage/saveingredient")
    public String saveIngredient(Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/manage";
    }

    @GetMapping("/manage/connect")
    public String connect(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        List<Ingredient> ingredients = ingredientService.getAllIngredients();

        model.addAttribute("dishlist",dishes);
        model.addAttribute("ingredientlist",ingredients);

        model.addAttribute("savedish", new Dish());
        model.addAttribute("saveingredient", new Ingredient());

        return "connect";
    }

    @PostMapping("/manage/connect/save")
    public String connectDishWithIngredient(Model model) {

        return "redirect:/manage";
    }





}

package com.example.slutprojekt.controller;

import com.example.slutprojekt.model.Dish;
import com.example.slutprojekt.model.Ingredient;
import com.example.slutprojekt.service.DishService;
import com.example.slutprojekt.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/manage/dish_form")
    public String addDish(Model model) {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("ingredientlist", ingredients);
        model.addAttribute("dish", new Dish());
        return "dish_form";
    }

    @PostMapping("/manage/savedish")
    public String saveDish(Dish dish) {
        //dish.addIngredients(ingredients);
        dishService.save(dish);
        return "redirect:/manage";
    }

    @GetMapping("/manage/ingredient_form")
    public String addIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredient_form";
    }

    @PostMapping("/manage/saveingredient")
    public String saveIngredient(Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/manage";
    }

    @GetMapping("/manage/deletedish/{id}")
    public String deleteDish(@PathVariable("id") Integer id) {
        dishService.deleteById(id);
        return "redirect:/manage";
    }

    @GetMapping("/manage/deleteingredient/{id}")
    public String deleteIngredient(@PathVariable("id") Integer id) {
        ingredientService.deleteById(id);
        return "redirect:/manage";
    }

    @GetMapping("/manage/updatedish/{id}")
    public String updateDish(@PathVariable("id") Integer id, Model model) {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("ingredientlist", ingredients);
        Dish dish = dishService.getById(id);
        model.addAttribute("dish",dish);
        
        return "dish_form";
    }

    @GetMapping("/manage/updatelikes/{id}")
    public String updateLikes(@PathVariable("id") Integer id) {
        Dish dish = dishService.getById(id);
        dishService.updateLikes(dish);
        return "redirect:/manage";
    }

    @GetMapping("/manage/updatedislikes/{id}")
    public String updateDislikes(@PathVariable("id") Integer id) {
        Dish dish = dishService.getById(id);
        dishService.updateDislikes(dish);
        return "redirect:/manage";
    }

    @GetMapping("/manage/updateingredient/{id}")
    public String updateIngredient(@PathVariable("id") Integer id, Model model) {
        Ingredient ingredient = ingredientService.get(id);
        model.addAttribute("ingredient", ingredient);

        return "ingredient_form";
    }

    @GetMapping("weekly_menu")
    public String showWeeklyMenu(Model model) {
        List<Dish> dishes = dishService.randomMenu();

        model.addAttribute("dishes", dishes);

        List<Ingredient> ingredients = dishService.ingredientList(dishes);

        model.addAttribute("ingredients", ingredients);
        return "weekly_menu";
    }

}

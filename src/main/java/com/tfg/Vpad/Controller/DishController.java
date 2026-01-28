package com.tfg.Vpad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.Vpad.Entity.Dish;
import com.tfg.Vpad.Service.DishService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // Made to handle CORS issues with Vite server
public class DishController {
    
    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @PostMapping("/dishes")
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.createDish(dish);
    }

    @PutMapping("/dishes/{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        return dishService.updateDish(id, dish);
    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}

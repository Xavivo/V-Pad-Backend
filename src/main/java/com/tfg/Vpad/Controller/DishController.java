package com.tfg.Vpad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.Vpad.Entity.Dish;
import com.tfg.Vpad.Service.DishService;
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
}

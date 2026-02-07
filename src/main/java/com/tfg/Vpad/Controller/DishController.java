package com.tfg.Vpad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.Vpad.Entity.Dish;
import com.tfg.Vpad.Service.DishService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
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
    public ResponseEntity<Dish> createDish(@Valid @RequestBody Dish dish) {
        Dish savedDish = dishService.saveDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDish);
    } // HttpStatus.CREATED = 201 CREATED

    @PutMapping("/dishes/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @Valid @RequestBody Dish dish) {
        Dish updatedDish = dishService.updateDish(id, dish);
        return ResponseEntity.ok(updatedDish);
    } // HttpStatus.OK = 200 OK

    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    } // HttpStatus.NO_CONTENT = 204 NO CONTENT
}

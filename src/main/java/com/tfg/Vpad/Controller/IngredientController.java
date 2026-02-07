package com.tfg.Vpad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.Vpad.Entity.Ingredient;
import com.tfg.Vpad.Service.IngredientService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api")
public class IngredientController {
    
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.saveIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient);
    } // HttpStatus.CREATED = 201 CREATED

    @PutMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @Valid @RequestBody Ingredient ingredient) {
        Ingredient updatedIngredient = ingredientService.updateIngredient(id, ingredient);
        return ResponseEntity.ok(updatedIngredient);
    } // HttpStatus.OK = 200 OK

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    } // HttpStatus.NO_CONTENT = 204 NO CONTENT
}

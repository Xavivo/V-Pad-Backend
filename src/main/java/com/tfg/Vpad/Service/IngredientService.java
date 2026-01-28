package com.tfg.Vpad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.Vpad.Entity.Ingredient;
import com.tfg.Vpad.Repository.IngredientRepository;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        Ingredient existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient con el id: " + id + " no encontrado"));

        existingIngredient.setName(ingredient.getName());

        return ingredientRepository.save(existingIngredient);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}

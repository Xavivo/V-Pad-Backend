package com.tfg.Vpad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.Vpad.Entity.Dish;
import com.tfg.Vpad.Repository.DishRepository;

@Service
public class DishService {
    
    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish saveDish(Dish dish) {
    return dishRepository.save(dish);
    }

    public Dish updateDish(Long id, Dish dish) {
        Dish existingDish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish con el id: " + id + " no encontrado"));
                
        existingDish.setName(dish.getName());
        existingDish.setDescription(dish.getDescription());
        existingDish.setPrice(dish.getPrice());
        existingDish.setIngredients(dish.getIngredients());
        return dishRepository.save(existingDish);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}

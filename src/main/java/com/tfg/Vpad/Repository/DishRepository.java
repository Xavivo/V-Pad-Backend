package com.tfg.Vpad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.Vpad.Entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
        
}
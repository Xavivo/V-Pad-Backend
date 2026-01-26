package com.tfg.Vpad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.Vpad.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // List<Order> findByStatus(String status);
}

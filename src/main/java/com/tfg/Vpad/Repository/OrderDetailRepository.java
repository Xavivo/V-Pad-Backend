package com.tfg.Vpad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.Vpad.Entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Normally, we don't need specific methods here,as JpaRepository provides basic CRUD operations.
}

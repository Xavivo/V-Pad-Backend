package com.tfg.Vpad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.Vpad.Entity.Order;
import com.tfg.Vpad.Service.OrderService;
import com.tfg.Vpad.DTO.OrderRequestDTO;

@RestController
@RequestMapping("/api")
public class OrderController {
    
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO request) {
        try {
            Order newOrder = orderService.createOrder(request);
            // Status 201 delivered when a resource is created
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PatchMapping("/orders/{id}/status")
    public ResponseEntity<Order> updateOrderStatus( 
            @PathVariable Long id, 
            @RequestBody String newStatus) { 
        try { 
            Order updated = orderService.updateStatus(id, newStatus);
            return ResponseEntity.ok(updated); 
        } catch (Exception e) { 
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/orders/by-status")
    public List<Order> getOrdersByStatus(@RequestParam String status) {
        return orderService.getOrdersByStatus(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}

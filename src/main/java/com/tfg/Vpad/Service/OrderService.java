package com.tfg.Vpad.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.Vpad.Entity.Dish;
import com.tfg.Vpad.Entity.Order;
import com.tfg.Vpad.Entity.OrderDetail;
import com.tfg.Vpad.Repository.DishRepository;
import com.tfg.Vpad.Repository.OrderDetailRepository;
import com.tfg.Vpad.Repository.OrderRepository;
import com.tfg.Vpad.DTO.OrderItemDTO;
import com.tfg.Vpad.DTO.OrderRequestDTO;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final DishRepository dishRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, 
                        OrderDetailRepository orderDetailRepository, 
                        DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional
    public Order createOrder(OrderRequestDTO request) {
        
        // Create and save the order first (without details)
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setStatus("PENDIENTE");
        order.setTotal(0.0);
        
        // We save first to get the ID
        Order savedOrder = orderRepository.save(order);

        double calculatedTotal = 0.0;
        List<OrderDetail> detailsList = new ArrayList<>();

        // Items in JSON request
        for (OrderItemDTO itemDTO : request.getItems()) {
            
            // Search for the dish by ID in the Database
            Dish dish = dishRepository.findById(itemDTO.getDishId())
                    .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + itemDTO.getDishId()));

            // Create detail and link to order and dish
            OrderDetail detail = new OrderDetail();
            detail.setOrder(savedOrder);
            detail.setDish(dish);
            detail.setQuantity(itemDTO.getQuantity());
            detail.setUnitPrice(dish.getPrice());

            //  We save detail
            orderDetailRepository.save(detail);
            
            // add
            detailsList.add(detail);

            calculatedTotal += (dish.getPrice() * itemDTO.getQuantity());
        }

        // Update order with total
        savedOrder.setTotal(calculatedTotal);
        savedOrder.setDetails(detailsList); // To see the details in the returned object
        
        return orderRepository.save(savedOrder);
    }
    
    // Extra method to fetch all orders (for testing purposes)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
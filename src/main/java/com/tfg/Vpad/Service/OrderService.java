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
import com.tfg.Vpad.Repository.OrderRepository;
import com.tfg.Vpad.DTO.OrderItemDTO;
import com.tfg.Vpad.DTO.OrderRequestDTO;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional
    public Order createOrder(OrderRequestDTO request) {

        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío.");
        }

        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setTotal(0.0);

        List<OrderDetail> details = new ArrayList<>();
        double total = 0.0;

        for (OrderItemDTO item : request.getItems()) {

            Dish dish = dishRepository.findById(item.getDishId())
                    .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado: " + item.getDishId()));

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setDish(dish);
            detail.setQuantity(item.getQuantity());
            detail.setUnitPrice(dish.getPrice());

            details.add(detail);

            total += dish.getPrice() * item.getQuantity();
        }

        order.setTotal(total);
        order.setDetails(details);

        return orderRepository.save(order);
    }

    @Transactional
    public Order updateStatus(Long id, String newStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));

        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void deleteOrder(Long id) {
    if (!orderRepository.existsById(id)) {
        throw new IllegalArgumentException("El pedido no existe");
    }
    orderRepository.deleteById(id);
}

}

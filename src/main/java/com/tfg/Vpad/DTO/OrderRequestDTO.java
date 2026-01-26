package com.tfg.Vpad.DTO;

import java.util.List;

import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class OrderRequestDTO {
    // Items that the order contains
    private List<OrderItemDTO> items;
}
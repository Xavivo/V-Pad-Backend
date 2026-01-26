package com.tfg.Vpad.DTO;

import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class OrderItemDTO {
    private Long dishId;   // Only the dish ID is needed
    private Integer quantity;

}

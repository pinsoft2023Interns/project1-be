package com.pinsoft.project1.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private String name;
    private Float price;
    private int quantity;
    private Long userId;
}

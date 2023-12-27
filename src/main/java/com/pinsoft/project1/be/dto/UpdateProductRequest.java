package com.pinsoft.project1.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Long id;
    private String name;
    private Float price;
    private String explanation;
    private Long categoryId;
}

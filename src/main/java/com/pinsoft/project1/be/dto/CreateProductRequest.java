package com.pinsoft.project1.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest implements Serializable {
    private String name;
    private Float price;
    private String explanation;
    private Long categoryId;
    private MultipartFile base64Image;

}

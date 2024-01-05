package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.dto.CreateProductRequest;
import com.pinsoft.project1.be.dto.UpdateProductRequest;
import com.pinsoft.project1.be.entity.Product;
import com.pinsoft.project1.be.servis.ProductService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    @PermitAll
    public Collection<Product> get(){
        return productService.getAll();
    }
    @GetMapping("/products/{id}")
    @PermitAll
    public Product get(@PathVariable Long id){
        Optional<Product> optional= productService.getById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @PostMapping("/products")
    public Product add(@RequestBody CreateProductRequest productRequest) throws IOException {
        return productService.add(productRequest);
    }

    @PutMapping("/products")
    public void update(@RequestBody UpdateProductRequest productRequest) {
        productService.update(productRequest);
    }
}

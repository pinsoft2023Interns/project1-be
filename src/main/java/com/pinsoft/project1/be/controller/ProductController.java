package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.entity.Product;
import com.pinsoft.project1.be.servis.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Collection<Product> get(){
        return productService.getAll();
    }
    @GetMapping("/products/{id}")
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
    public Product add(@RequestBody Product product){
        return productService.add(product);
    }
}

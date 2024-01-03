package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.dto.CreateOrderRequest;
import com.pinsoft.project1.be.entity.Order;
import com.pinsoft.project1.be.servis.OrderService;
import jakarta.annotation.security.PermitAll;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders/{userId}")
    @PermitAll
    public List<Order> get(@PathVariable Long userId){
        try {
            return orderService.getByUserId(userId);
        }catch (NoSuchElementException noSuchElementException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orders")
    public Order create(@RequestBody CreateOrderRequest orderRequest){
        return orderService.create(orderRequest);
    }
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }




}

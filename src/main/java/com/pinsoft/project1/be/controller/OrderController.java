package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.dto.CreateOrderRequest;
import com.pinsoft.project1.be.entity.Order;
import com.pinsoft.project1.be.servis.OrderService;
import jakarta.annotation.security.PermitAll;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders/{id}")
    @PermitAll
    public Order get(@PathVariable Long id){
        Optional<Order> optional = orderService.getById(id);
        if (optional.isPresent()){
            return optional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/orders")
    public Order create(@RequestBody CreateOrderRequest orderRequest){
        return orderService.create(orderRequest);
    }
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Order> optional = orderService.getById(id);
        if(optional.isPresent()){
            orderService.delete(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}

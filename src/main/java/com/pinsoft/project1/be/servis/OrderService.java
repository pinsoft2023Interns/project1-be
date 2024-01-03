package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.dto.CreateOrderRequest;
import com.pinsoft.project1.be.entity.Order;
import com.pinsoft.project1.be.entity.User;
import com.pinsoft.project1.be.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    public Order create(CreateOrderRequest orderRequest){
        Order order = new Order();
        order.setName(orderRequest.getName());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        User user = userService.getById(orderRequest.getUserId()).get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    public List<Order> getByUserId(Long userId) {
        User user = userService.getById(userId).get();
        return orderRepository.findAllByUser(user);
    }
    public void delete(Long id) {orderRepository.deleteById(id);}





}

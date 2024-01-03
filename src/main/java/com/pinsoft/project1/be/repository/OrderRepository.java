package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.Order;
import com.pinsoft.project1.be.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser(User user);

}

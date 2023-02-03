package com.example.app.service;

import com.example.app.model.orders.Order;
import com.example.app.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    public Order create(Order order){
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }

    public Order update(Order order){
        return this.orderRepository.save(order);
    }

}

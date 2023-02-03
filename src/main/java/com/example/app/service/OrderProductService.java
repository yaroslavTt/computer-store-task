package com.example.app.service;

import com.example.app.model.orders.OrderProduct;
import com.example.app.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}

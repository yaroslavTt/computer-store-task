package com.example.app.repository;

import com.example.app.model.orders.OrderProduct;
import com.example.app.model.orders.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}

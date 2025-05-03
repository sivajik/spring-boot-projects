package com.sprms.order_service.service;

import com.sprms.order_service.dto.OrderRequest;
import com.sprms.order_service.model.Order;
import com.sprms.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();
        orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }
}

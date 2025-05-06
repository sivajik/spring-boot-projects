package com.sprms.order_service.service;

import com.sprms.order_service.client.InventoryClient;
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
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        boolean isProdInStock = inventoryClient.isInStock((orderRequest.skuCode()), orderRequest.quantity());

        if (isProdInStock) {
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(orderRequest.price())
                    .skuCode(orderRequest.skuCode())
                    .quantity(orderRequest.quantity())
                    .build();
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with skucode is not in stock..");
        }
    }

    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }
}

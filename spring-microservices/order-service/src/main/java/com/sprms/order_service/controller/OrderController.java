package com.sprms.order_service.controller;

import com.sprms.order_service.dto.OrderRequest;
import com.sprms.order_service.model.Order;
import com.sprms.order_service.repository.OrderRepository;
import com.sprms.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "order placed successfully..";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}

package com.ecommerce.orderservice.controller;

import com.ecommerce.orderservice.dto.OrderRequest;
import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // ✅ 1. Place Order
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {
        return service.placeOrder(request);
    }

    // ✅ 2. Get All Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return service.getall();
    }
}
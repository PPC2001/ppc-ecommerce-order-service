package com.ppc.ecommerce.order.controller;

import com.ppc.ecommerce.order.service.OrderService;
import com.ppc.ecommerce.sdk.dto.ApiResponse;
import com.ppc.ecommerce.sdk.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDto>>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(ApiResponse.success(orders, "Fetched all orders successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDto>> getOrderById(@PathVariable String id) {
        OrderDto order = orderService.getOrderById(id);
        if (order == null) {
            return ResponseEntity.status(404).body(ApiResponse.error("Order not found with ID: " + id));
        }
        return ResponseEntity.ok(ApiResponse.success(order, "Order details retrieved"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDto>> createOrder(@RequestBody OrderDto order) {
        OrderDto created = orderService.createOrder(order);
        return ResponseEntity.status(201).body(ApiResponse.success(created, "Order created successfully"));
    }
}

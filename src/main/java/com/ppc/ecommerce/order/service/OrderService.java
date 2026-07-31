package com.ppc.ecommerce.order.service;

import com.ppc.ecommerce.sdk.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final List<OrderDto> orders = new ArrayList<>(List.of(
            OrderDto.builder()
                    .orderId("ORD-1001")
                    .customerId("CUST-501")
                    .totalAmount(new BigDecimal("289.98"))
                    .status("PAID")
                    .createdAt(LocalDateTime.now().minusDays(1))
                    .items(List.of(
                            OrderDto.OrderItemDto.builder().productId("PROD-001").quantity(1).price(new BigDecimal("199.99")).build(),
                            OrderDto.OrderItemDto.builder().productId("PROD-002").quantity(1).price(new BigDecimal("89.99")).build()
                    ))
                    .build()
    ));

    public List<OrderDto> getAllOrders() {
        return orders;
    }

    public OrderDto getOrderById(String orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                .findFirst()
                .orElse(null);
    }

    public OrderDto createOrder(OrderDto order) {
        if (order.getOrderId() == null) {
            order.setOrderId("ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());
        orders.add(order);
        return order;
    }
}

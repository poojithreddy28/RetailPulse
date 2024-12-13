package com.poojith.microservices.order.service;


import com.poojith.microservices.order.client.InventoryClient;
import com.poojith.microservices.order.dto.OrderRequest;
import com.poojith.microservices.order.model.Order;
import com.poojith.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public void placeOrder(OrderRequest orderRequest) {

        // map order request to order object model
        // check if the product is in stock
        if (!inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity())) {
            throw new RuntimeException("Product is out of stock for SkuCode: " + orderRequest.skuCode());
        }
        // save order object to database
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        // save order to database
        orderRepository.save(order);



    }
}


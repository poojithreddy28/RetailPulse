package com.poojith.microservices.order.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderPlacedEvent {
    private String orderNumber;
    private String email;

    public OrderPlacedEvent(String orderNumber, String email) {
        this.orderNumber = orderNumber;
        this.email = email;
    }
}

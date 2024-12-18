package com.poojith.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequest(String Id, String name, String description,String skuCode, BigDecimal price) {
}

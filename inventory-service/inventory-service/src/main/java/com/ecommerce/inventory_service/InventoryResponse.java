package com.ecommerce.inventory_service;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long productId;
    private Integer quantity;
}

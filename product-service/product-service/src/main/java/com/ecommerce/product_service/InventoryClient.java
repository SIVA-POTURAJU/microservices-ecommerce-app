package com.ecommerce.product_service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {
    private final RestTemplate restTemplate;

    public InventoryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isInStock(Long productId) {
        try {
            String url = "http://localhost:8082/api/inventory/check/" + productId + "/1";
            Boolean response = restTemplate.getForObject(url, Boolean.class);
            return response != null && response;
        } catch (Exception e) {
            System.out.println("Inventory service error: " + e.getMessage());
            return false; // fallback
        }
    }

}

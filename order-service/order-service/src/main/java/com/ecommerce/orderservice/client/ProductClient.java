package com.ecommerce.orderservice.client;

import com.ecommerce.orderservice.dto.ProductResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {
    private final RestTemplate restTemplate;
    public ProductClient(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public ProductResponse getProduct(Long productId){
        String url="http://localhost:8081/api/products/"+productId;
        return restTemplate.getForObject(url,ProductResponse.class);
    }
}

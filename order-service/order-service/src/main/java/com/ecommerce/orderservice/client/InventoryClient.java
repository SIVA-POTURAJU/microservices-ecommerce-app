package com.ecommerce.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {
    private final RestTemplate restTemplate;

    public InventoryClient(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    //check stock
    public boolean checkStock(Long productId,int quantity){
        String url="http://localhost:8082/api/inventory/check/"+productId+"/"+quantity;
        return restTemplate.getForObject(url,Boolean.class);
    }
    //reduce stock
    public void reduceStock(Long productId,int quantity){
        String url="http://localhost:8082/api/inventory/reduce/"+productId+"/"+quantity;
         restTemplate.postForObject(url,null,String.class);
    }
}

package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.client.InventoryClient;
import com.ecommerce.orderservice.client.ProductClient;
import com.ecommerce.orderservice.dto.OrderRequest;
import com.ecommerce.orderservice.dto.ProductResponse;
import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repo;
    private final InventoryClient inventoryClient;
    private final ProductClient productClient;

    public OrderService(OrderRepository repo,
                        InventoryClient inventoryClient,
                        ProductClient productClient) {
        this.repo = repo;
        this.inventoryClient = inventoryClient;
        this.productClient = productClient;
    }

    public List<Order>getall(){
        return repo.findAll();
    }

    public String placeOrder(OrderRequest request) {

        // 1. Get product details
        ProductResponse product = productClient.getProduct(request.getProductId());

        if (product == null) {
            return "Product not found!";
        }

        // 2. Check stock
        boolean inStock = inventoryClient.checkStock(
                request.getProductId(),
                request.getQuantity()
        );

        if (!inStock) {
            return "Product out of stock!";
        }

        // 3. Reduce stock
        inventoryClient.reduceStock(
                request.getProductId(),
                request.getQuantity()
        );

        // 4. Calculate total amount
        double totalAmount = product.getPrice() * request.getQuantity();

        // 5. Save order
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setTotalAmount(totalAmount);
        order.setStatus("PLACED");

        repo.save(order);

        return "Order placed successfully!";
    }
}

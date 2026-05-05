package com.ecommerce.product_service;

import com.ecommerce.product_service.Product;
import com.ecommerce.product_service.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //This contains Business logic
public class ProductService {

    private final ProductRepository repo;

    private final InventoryClient inventoryClient;

    public ProductService(ProductRepository repo, InventoryClient inventoryClient) {
        this.repo = repo;
        this.inventoryClient = inventoryClient;
    }
    public  List<Product>getal(){
        return repo.findAll();
    }
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = repo.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        return repo.save(existing);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }

}
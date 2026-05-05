package com.ecommerce.product_service;
import com.ecommerce.product_service.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Repository it handles the all Database's operations
public interface ProductRepository
        extends JpaRepository<Product,Long> {
}

package com.ecommerce.inventory_service;
import com.ecommerce.inventory_service.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InventoryRepository
        extends JpaRepository<Inventory,Long> {

    Optional<Inventory> findByProductId(Long productId);
}

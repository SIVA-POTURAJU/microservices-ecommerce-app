package com.ecommerce.inventory_service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    //view all
    public List<Inventory> getAll(){
        return repo.findAll();
    }

    //view by id
    public Inventory getInventoryById(Long id){
        return repo.findByProductId(id).orElse(null);
    }

    //check stock
    public boolean isInStock(Long productId, int quantity) {
        Inventory inv = repo.findByProductId(productId).orElseThrow();
        return inv.getQuantity() >= quantity;
    }

    // Reduce stock
    public void reduceStock(Long productId, int quantity) {
        Inventory inv = repo.findByProductId(productId)
                .orElseThrow();

        if (inv.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        inv.setQuantity(inv.getQuantity() - quantity);
        repo.save(inv);
    }

    // Add stock
    public Inventory addStock(Long productId, int quantity) {
        Inventory inv = repo.findByProductId(productId)
                .orElse(new Inventory(null, productId, 0));

        inv.setQuantity(inv.getQuantity() + quantity);
        return repo.save(inv);
    }

}

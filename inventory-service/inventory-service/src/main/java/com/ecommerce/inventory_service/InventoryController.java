package com.ecommerce.inventory_service;

import com.ecommerce.inventory_service.Inventory;
import com.ecommerce.inventory_service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")

public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
   public List<Inventory> get(){
        return service.getAll();
   }

   @GetMapping("/{id}")
   public Inventory getById(@PathVariable Long id){
        return service.getInventoryById(id);
   }
    // Check stock
    @GetMapping("/check/{productId}/{quantity}")
    public boolean checkStock(@PathVariable Long productId,
                              @PathVariable int quantity) {
        return service.isInStock(productId, quantity);
    }

    // Reduce stock
    @PostMapping("/reduce/{productId}/{quantity}")
    public String reduce(@PathVariable Long productId,
                         @PathVariable int quantity) {
        service.reduceStock(productId, quantity);
        return "Stock updated";
    }

    // Add stock
    @PostMapping("/add")
    public Inventory add(@RequestParam Long productId,
                         @RequestParam int quantity) {
        return service.addStock(productId, quantity);
    }
}
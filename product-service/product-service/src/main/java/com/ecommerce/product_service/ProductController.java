package com.ecommerce.product_service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //It returns JSON response & it's combination of @Controller + @ResponseBody
@RequestMapping("/api/products") //Maps URL to the Controller

public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){
        this.service=service;
    }

    @GetMapping //HTTP Request Method for read data
    public List<Product>getviewall(){
        return service.getal();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return service.getProductById(id);
    }
    @PostMapping("/add") //HTTP Request method for insert data
    public Product add(@RequestBody Product product){
        return service.addProduct(product);
    }
    @PutMapping("/{id}") //HTTP Request method for update data
    public Product update(@PathVariable Long id,@RequestBody Product product){
        return  service.updateProduct(id,product);
    }
    @DeleteMapping("/{id}") //HTTP Request method for delete data
    public String delete(@PathVariable Long id){
            service.deleteProduct(id);
            return "Deleted successfully";
        }
    }


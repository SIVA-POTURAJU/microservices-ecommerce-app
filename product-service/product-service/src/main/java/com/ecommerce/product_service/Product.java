package com.ecommerce.product_service;

import jakarta.persistence.*;
import lombok.*;

@Entity //marks database table
@Table(name = "products") //specify table name
@Data //it gives getters and setters
@NoArgsConstructor //Generates constructor with no arguments
@AllArgsConstructor //Generates constructors assign all fields in class
public class Product {

    @Id //Marks primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Type of
    private Long id;

        private String name;
        private String description;
        private Double price;

}
package com.example.NileInventory.NileInventory.Product;
import jakarta.persistence.*;

@Entity
@Table
public class Product {

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, long id) {
        this.name = name;
        this.id  = id;
    }


    @Id
    public long id;
    public String name;

    public Product() {

    }
}

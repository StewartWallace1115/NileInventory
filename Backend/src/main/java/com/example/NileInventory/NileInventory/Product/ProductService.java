package com.example.NileInventory.NileInventory.Product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> GetProducts(){
        return this.productRepository.findAll();
    }

    public Product GetProduct(Product product){
        Optional<Product> productName = this.productRepository.findProductByName(product.name);
        return productName.orElseGet(Product::new);
    }

    public void AddNewProduct(Product product){
        this.productRepository.save(product);
    }

    public boolean DeleteProduct(Product product){
        boolean exists = this.productRepository.existsById(product.id);

        if(exists){
            this.productRepository.deleteById(product.id);
        }
        return exists;
    }

    public boolean DeleteIdProduct(int id){
        boolean exists = this.productRepository.existsById((long) id);

        if(exists){
            this.productRepository.deleteById((long) id);
        }
        return exists;
    }


    public boolean UpdateProduct(Product product){
        Product productEntity = this.productRepository.findById(product.id).orElse(null);

        if(productEntity == null)
            return false;

        if(product.name.length() >0 && !Objects.equals(productEntity.name, product.name)){
            productEntity.name = product.name;
        }

        return true;
    }
}

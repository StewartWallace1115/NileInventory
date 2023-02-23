package com.example.NileInventory.NileInventory;

import com.example.NileInventory.NileInventory.Product.*;
//import graphql.Assert;
import org.junit.jupiter.api.Test;

import static graphql.Assert.assertNotEmpty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.Assert;

@SpringBootTest
public class ProductControllerTests {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void GetAllProducts_test(){
        ProductController productController = new ProductController(productService);
        var result =  productController.GetProducts();
        assertNotEmpty(result);
    }

    @Test
    public void GetProduct_test(){
        ProductController productController = new ProductController(productService);
        Product product = new Product();
        product.name = "Book";
        var result =  productController.GetProduct(product);
        assertNotNull(result, "Productrequest is null");
        assertEquals(result.name, "Book");

    }

    @Test
    public void SaveProduct_test(){
        ProductController productController = new ProductController(productService);
        var result =  productController.GetProducts();
        assertNotEmpty(result);
    }

    @Test
    public void UpdateProduct_test(){
        ProductController productController = new ProductController(productService);
        Product product = new Product();
        product.name = "Games";
        product.id = 1;
        var result =  productController.UpdateProduct(product);
        assertEquals(result.getStatusCode().value(), 200);
    }

    @Test
    public void UpdateProduct_notFound_test(){
        ProductController productController = new ProductController(productService);
        Product product = new Product();
        product.name = "Games";
        product.id = 3;
        var result =  productController.UpdateProduct(product);
        assertEquals(result.getStatusCode().value(), 404);
    }

    @Test
    public void CreateProduct_NonExistingProduct_test(){
        ProductController productController = new ProductController(productService);
        Product product = new Product();
        product.name = "Games";
        product.id = 3;
        var result =  productController.UpdateProduct(product);
        assertEquals(result.getStatusCode().value(), 404);
    }

    @Test
    public void CreateProduct_ExistingProduct_test(){
        ProductController productController = new ProductController(productService);
        Product product = new Product();
        product.name = "Games";
        product.id = 3;
        var result =  productController.UpdateProduct(product);
        assertEquals(result.getStatusCode().value(), 404);
    }
}

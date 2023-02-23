package com.example.NileInventory.NileInventory.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> GetProducts(){
        return this.productService.GetProducts();
        //return Arrays.asList(new Product("Book"), new Product("Food"));
    }

    @PostMapping(path="product")
    public Product GetProduct(@RequestBody Product product){
        return this.productService.GetProduct(product);
    }
    @PostMapping
    public ResponseEntity<Product> CreateProduct(@RequestBody Product product) {
        this.productService.AddNewProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping(path="{product}")
    public ResponseEntity<Product> UpdateProduct(@RequestBody Product product) {
        boolean exists = this.productService.UpdateProduct(product);

        if(exists)
        {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path="{product}")
    public ResponseEntity<Product> DeleteProduct(Product product) {
        boolean exists = this.productService.DeleteProduct(product);

        if(exists)
        {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path="delete")
    public ResponseEntity<Product> DeleteProductId(int id) {
        boolean exists = this.productService.DeleteIdProduct(id);

        if(exists)
        {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

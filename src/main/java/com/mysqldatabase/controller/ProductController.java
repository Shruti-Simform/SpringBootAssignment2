package com.mysqldatabase.controller;

import com.mysqldatabase.entity.Product;
import com.mysqldatabase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/create")
    public Product saveProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        return service.updateProduct(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        if (service.productExistsById(id)) {
            service.deleteProduct(id);
            return new ResponseEntity<String>("Product removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product doesn't exist", HttpStatus.OK);
        }
    }
}

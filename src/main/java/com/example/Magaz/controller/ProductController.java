package com.example.Magaz.controller;

import com.example.Magaz.entities.Product;
import com.example.Magaz.reposotories.MagazineRepository;
import com.example.Magaz.reposotories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable UUID id){
        Product product;
        try {
            product = productRepository.findById(id).get();
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody Product jsonFile){
        return new ResponseEntity<>(productRepository.save(jsonFile), HttpStatus.CREATED);
    }








}

package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.controller.repositories.ProductRepository;
import com.devsuperior.dscommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    ProductRepository productRepository;


    @GetMapping
    public String listProducts(Long id) {
        Optional<Product> result = productRepository.findById(1L);
        Product product = result.get();
        return product.getName();
    }
}

package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.controller.repositories.ProductRepository;
import com.devsuperior.dscommerce.dto.ProductDto;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    ProductService productService;


    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);

        //        ProductDto dto = productService.findById(id);
        //        return dto;
    }

    @GetMapping
    public Page<ProductDto> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @PostMapping
    public ProductDto insert(@RequestBody ProductDto dto )
    {
       return productService.insert(dto);
    }
}

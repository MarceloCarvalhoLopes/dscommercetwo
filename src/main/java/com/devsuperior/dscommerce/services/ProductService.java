package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.controller.repositories.ProductRepository;
import com.devsuperior.dscommerce.dto.ProductDto;
import com.devsuperior.dscommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDto findById (Long id){
        Product product = productRepository.findById(id).get();
        return  new ProductDto(product);

//        Optional<Product> result = productRepository.findById(id);
//        Product product = result.get();
//        ProductDto dto = new ProductDto(product);
//        return dto;

    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll (Pageable pageable){
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(ProductDto::new);
    }


}

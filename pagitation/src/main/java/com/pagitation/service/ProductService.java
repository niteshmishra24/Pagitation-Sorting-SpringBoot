package com.pagitation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pagitation.model.Product;
import com.pagitation.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return productRepository.findAll(pageable);
    }

    public void createProducts(List<Product> products){
        productRepository.saveAll(products);
    }
}

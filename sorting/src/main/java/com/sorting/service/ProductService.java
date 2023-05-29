package com.sorting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sorting.entity.Product;
import com.sorting.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProductsSortedByName(){
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        return productRepository.findAll(sort);
    }

    public void createProducts(List<Product> products){
        productRepository.saveAll(products);
    }
}

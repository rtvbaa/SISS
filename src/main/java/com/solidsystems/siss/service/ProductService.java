package com.solidsystems.siss.service;


import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductEntity productEntity;
    @Autowired
    public ProductRepository productRepository;

    public void add(Product product) {
        productEntity.setName(product.getName());
        productEntity.setProductDescription(product.getProductDescription());
        productRepository.saveAndFlush(productEntity);
    }

    public List<ProductEntity> get() {
        return productRepository.findAll();
    }
}

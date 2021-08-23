package com.solidsystems.siss.service;


import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductEntity productEntity;

    @Autowired
    public ProductRepository productRepository;

    public ProductEntity add(Product product) {
        productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setProductDescription(product.getProductDescription());
        return productRepository.saveAndFlush(productEntity);
    }

    public List<ProductEntity> get() {
        return productRepository.findAll();
    }
}

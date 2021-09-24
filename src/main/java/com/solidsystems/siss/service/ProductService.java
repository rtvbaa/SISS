package com.solidsystems.siss.service;


import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity add(Product product) {
        ProductEntity productEntity;
        if (product.getId() == null || !productRepository.findById(product.getId()).isPresent()) {
            productEntity = new ProductEntity();
        } else {
            productEntity = productRepository.findById(product.getId()).get();
        }
        productEntity.setProductName(product.getProductName());
        productEntity.setProductPrice(product.getProductPrice());
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }
}

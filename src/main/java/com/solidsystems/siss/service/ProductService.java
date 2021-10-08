package com.solidsystems.siss.service;


import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.controller.model.Sale;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if (product.getId() == null || productRepository.findById(product.getId()).isEmpty()) {
            productEntity = new ProductEntity();
        } else {
            productEntity = productRepository.findById(product.getId()).get();
        }
        productEntity.setProductName(product.getProductName());
        productEntity.setProductPrice(product.getProductPrice());
        return productRepository.save(productEntity);
    }
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        for (ProductEntity productEntity : productRepository.findAll()) {
            List<Sale> saleList = new ArrayList<>();
            for (SaleEntity saleEntity : productEntity.getSales()) {
                saleList.add(new Sale(saleEntity.getId(), saleEntity.getSaleDate(), saleEntity.getDiscountId()));
            }
            productList.add(new Product(productEntity.getId(), productEntity.getProductName(), productEntity.getProductPrice(), saleList));
        }
        return productList;
    }
}

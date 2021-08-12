package com.solidsystems.siss.dao;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.model.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;

public class AddProductDB {
    @Autowired
    public ProductDB productDB;

    public void add(Product product) {
        productDB.setName(product.getName());
        productDB.setProductDescription(product.getProductDescription());

    }
}


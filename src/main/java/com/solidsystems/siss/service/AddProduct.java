package com.solidsystems.siss.service;


import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.AddProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProduct {

    @Autowired
    public AddProductDB addProductDB;

    public void add(Product product) {
        addProductDB.add(product.getName(), product.getProductDescription());
    }
}

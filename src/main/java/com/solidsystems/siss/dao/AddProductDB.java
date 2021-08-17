package com.solidsystems.siss.dao;

import com.solidsystems.siss.dao.model.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductDB {
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public ProductDB productDB;

    public void add(String name, String productDescription) {
        productDB.setName(name);
        productDB.setProductDescription(productDescription);
        productRepository.save(productDB);

    }

}


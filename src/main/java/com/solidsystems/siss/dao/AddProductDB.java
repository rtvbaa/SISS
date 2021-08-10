package com.solidsystems.siss.dao;

import com.solidsystems.siss.controller.models.Product;
import com.solidsystems.siss.dao.modelsDB.ProductDB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddProductDB {
    public static void add(Product product) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProductDB.class);
        context.getBean(ProductDB.class).setName(product.getName());
        context.getBean(ProductDB.class).setProductDescription(product.getProductDescription());

    }
}


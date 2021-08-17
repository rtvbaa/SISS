package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.AddProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    Product product;
    @Autowired
    AddProductDB addProductDB;

    @GetMapping("/get")
    public Product getProduct() {
        return product;
    }

    @PostMapping(value = "/post",
            produces = { "application/json;charset=UTF-8" },
            consumes = { "application/json" })
    public Product postProduct(@RequestBody Product product) {
        addProductDB.add(product);
        return product;
    }
}

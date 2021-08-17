package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.service.AddProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    Product product;
    @Autowired
    AddProduct addProduct;

    @GetMapping("/get")
    public Product getProduct() {
        return product;
    }

    @PostMapping(value = "/post",
            produces = {"application/json;charset=UTF-8"},
            consumes = {"application/json"})
    public Product postProduct(@RequestBody Product product) {
        addProduct.add(product);
        return product;
    }
}

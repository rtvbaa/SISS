package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.models.Product;
import com.solidsystems.siss.dao.AddProductDB;
import com.solidsystems.siss.dao.modelsDB.ProductDB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("/get")
    @ResponseBody
    public Product getProduct() {
        Product product = new Product();
        return product;
    }

    @PostMapping(value = "/post",
            produces = { "application/json;charset=UTF-8" },
            consumes = { "application/json" })
    @ResponseBody
    public Product postProduct(@RequestBody Product product) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AddProductDB.class);
        context.getBean(AddProductDB.class).add(product);
        return product;
    }
}

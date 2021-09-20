package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.model.Product;
import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get")
    public List<ProductEntity> getProduct() {
        return productService.getAll();
    }

    @PostMapping(value = "/post",
            produces = {"application/json;charset=UTF-8"},
            consumes = {"application/json"})
    public ProductEntity postProduct(@RequestBody Product product) {
        return productService.add(product);
    }
}

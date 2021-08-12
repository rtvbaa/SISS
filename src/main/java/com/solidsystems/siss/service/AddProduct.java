package com.solidsystems.siss.service;


import com.solidsystems.siss.controller.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AddProduct {
    Product good = new AnnotationConfigApplicationContext(Product.class).getBean(Product.class);

    public void random(){
        good.setId(1);
        good.setName("phone");
    }


}

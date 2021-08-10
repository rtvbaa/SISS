package com.solidsystems.siss.servise;


import com.solidsystems.siss.controller.models.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddGood {
    Product good = new AnnotationConfigApplicationContext(Product.class).getBean(Product.class);

    public void random(){
        good.setId(1);
        good.setName("phone");
    }
}

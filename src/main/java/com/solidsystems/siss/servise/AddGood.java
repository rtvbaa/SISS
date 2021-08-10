package com.solidsystems.siss.servise;


import com.solidsystems.siss.controller.models.Goods;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddGood {
    Goods good = new AnnotationConfigApplicationContext(Goods.class).getBean(Goods.class);

    public void random(){
        good.setId(1);
        good.setName("phone");
    }
}

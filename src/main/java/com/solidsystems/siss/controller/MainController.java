package com.solidsystems.siss.controller;

import com.solidsystems.siss.controller.models.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @GetMapping("/")
    @ResponseBody
    public Goods greeting() {
        Goods goods = new Goods();
        return goods;
    }
}

package com.solidsystems.siss.controller;

import com.solidsystems.siss.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HtmlController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String get(Model model) {
        model.addAttribute("productService", productService.getAll());
        return "index";
    }
}

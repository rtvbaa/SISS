package com.solidsystems.siss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String get() {
        return "index";
    }
}

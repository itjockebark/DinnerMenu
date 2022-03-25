package com.example.slutprojekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }
}

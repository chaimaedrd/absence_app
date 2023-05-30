package com.chaimae.absence_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @GetMapping("/login")
    public String test() {
        return "login";
    }

    @GetMapping("/index")

    public String index() {
        return "index";
    }

    @GetMapping("/cadreAdminHome")

    public String cadreAdminHome() {
        return "cadreAdminHome";
    }

}

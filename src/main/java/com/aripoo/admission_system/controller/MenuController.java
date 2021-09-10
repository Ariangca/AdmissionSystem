package com.aripoo.admission_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MenuController {
    @GetMapping(path = "menu")
    public String menuPage(){
        return "menu";
    }
}

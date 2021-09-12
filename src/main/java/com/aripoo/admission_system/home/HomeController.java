package com.aripoo.admission_system.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping(path = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }
}

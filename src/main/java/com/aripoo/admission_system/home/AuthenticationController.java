package com.aripoo.admission_system.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class AuthenticationController {

    @GetMapping(path = "/login")
    public String getLoginView(Model model) {
        return "login";
    }
    @GetMapping(path = "/logout")
    public String getLogoutView(Model model) {
        return "logout";
    }

    @GetMapping(path = "/login_error")
    public String getLoginErrorView(){
        return "error/login";
    }
}

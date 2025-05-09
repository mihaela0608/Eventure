package com.example.demo.web;

import com.example.demo.service.session.UserHelperService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserHelperService userHelperService;

    public HomeController (UserHelperService userHelperService) {
        this.userHelperService = userHelperService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("home")
    public String home(Authentication authentication, Model model){
        model.addAttribute("username", userHelperService.getUser().getName());
        return "home";
    }

    //TODO: In the html file there is a problem with the style of the logout button
}

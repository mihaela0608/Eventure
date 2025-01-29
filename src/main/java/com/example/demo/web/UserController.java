package com.example.demo.web;

import com.example.demo.model.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @GetMapping("/register")
    public String viewRegister(Model model){
        if (!model.containsAttribute("userData")){
            model.addAttribute("userData", new UserRegistrationDto());
        }
        return "registration";
    }
    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDto userData, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userData.getPassword().equals(userData.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userData", userData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userData", bindingResult);
            System.out.println();
            return"redirect:/register";
        }
        return "index";
    }

}

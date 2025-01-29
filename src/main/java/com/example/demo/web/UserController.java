package com.example.demo.web;

import com.example.demo.model.dto.UserRegistrationDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

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
            return"redirect:/register";
        }
        boolean success = userService.registerUser(userData);
        if (!success){
            redirectAttributes.addFlashAttribute("userData", userData);
            redirectAttributes.addFlashAttribute("occupied", true);
            return "redirect:/register";
        }
        return "redirect:/";

    }

}

package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
    @GetMapping("/organizer-request")
    public String organizerRequest(){
        return "organizer-request";
    }
}

package com.example.demo.web;

import com.example.demo.model.dto.EventRequestDto;
import com.example.demo.service.EventService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EventController {
    private final EventService eventService;

    public EventController (EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/organizer-request")
    public String organizerRequest(Model model){
        if(!model.containsAttribute("eventRequest")){
            model.addAttribute("eventRequest", new EventRequestDto());
        }
        return "organizer-request";
    }

    @PostMapping("/organizer-request")
    public String createRequest(@Valid EventRequestDto eventRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("eventRequest", eventRequest);
            redirectAttributes.addFlashAttribute("error", true);
            return"redirect:/organizer-request";
        }

        eventService.eventRequesting(eventRequest);
        return "redirect:/home";
    }
}

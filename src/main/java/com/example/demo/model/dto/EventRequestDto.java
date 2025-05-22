package com.example.demo.model.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EventRequestDto {
    @NotEmpty
    private String fullName;

    @NotEmpty
    private String eventIdea;

    @NotEmpty
    private String motivation;

    public String getFullName () {
        return fullName;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }

    public String getEventIdea () {
        return eventIdea;
    }

    public void setEventIdea (String eventIdea) {
        this.eventIdea = eventIdea;
    }

    public String getMotivation () {
        return motivation;
    }

    public void setMotivation (String motivation) {
        this.motivation = motivation;
    }
}

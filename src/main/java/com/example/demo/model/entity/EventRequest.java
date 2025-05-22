package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_requests")
public class EventRequest extends BaseEntity{
    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Column(nullable = false, name = "event_idea")
    private String eventIdea;

    @Column(nullable = false)
    private String motivation;

    private long userId;

    public long getUserId () {
        return userId;
    }

    public void setUserId (long userId) {
        this.userId = userId;
    }

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

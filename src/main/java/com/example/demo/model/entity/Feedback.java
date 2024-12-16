package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@Getter
@Setter
public class Feedback extends BaseEntity{

    @ManyToOne
    private User user;
    @ManyToOne
    private Event event;
    @Column(nullable = false)
    private int rating;
    private String comments;
    @Column(nullable = false, name = "submitted_at")
    private LocalDateTime submittedAt;
}

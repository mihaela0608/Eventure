package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "analysis")
@Getter
@Setter
public class Analytic extends BaseEntity{

    @OneToOne
    private Event event;
    @Column(nullable = false, name = "total_participants")
    private long totalParticipants;
    @Column(nullable = false)
    private double averageRating;
    @Column(nullable = false)
    private LocalDateTime createdAt;
}

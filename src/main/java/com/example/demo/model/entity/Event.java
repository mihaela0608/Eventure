package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Collate;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event extends BaseEntity{

    @Column(nullable = false)
    private String title;
    private String description;
    @ManyToOne
    private Category category;
    @Column(nullable = false)
    private LocalDateTime eventDate;
    @Column(nullable = false)
    private String location;
    @Column(name = "max_participants")
    private long maxParticipants;
    @ManyToOne
    private Company company;
}

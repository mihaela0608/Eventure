package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity{

    @Column(name = "event_type")
    @Enumerated(value = EnumType.STRING)
    private EventType eventType;
}

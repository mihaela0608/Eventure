package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public Role() {
        this.users = new ArrayList<>();
    }

    public String getName () {
        return name;
    }
    //TODO: Fix getter annotation

}

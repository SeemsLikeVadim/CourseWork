package com.example.coursework.model;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    public Role(String name) {
        this.name = name;
    }

    public Role() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

}

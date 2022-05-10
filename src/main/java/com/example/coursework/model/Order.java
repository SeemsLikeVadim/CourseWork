package com.example.coursework.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String date;

    private String cake;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Order() {
    }

    public Order(String address, String date, String cake, User user) {
        this.address = address;
        this.date = date;
        this.cake = cake;
        this.user = user;
    }
}

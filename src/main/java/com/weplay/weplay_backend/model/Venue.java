package com.weplay.weplay_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String sport;

    @Column(nullable = false)
    private double pricePerHour;

    @Column
    private String description;

    @Column
    private String imageUrl;
}
package com.works.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    private String title;
    private String address;

    @ManyToMany
    private List<City> cities;

}

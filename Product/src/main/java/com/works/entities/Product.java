package com.works.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Size(min = 2, max = 200)
    @NotEmpty
    @NotNull
    @Column(length = 200)
    private String title;

    @Size(min = 2, max = 500)
    @NotEmpty
    @NotNull
    @Column(length = 500)
    private String description;

    @NotNull
    @Max(100000)
    @Min(1)
    private BigDecimal price;

}

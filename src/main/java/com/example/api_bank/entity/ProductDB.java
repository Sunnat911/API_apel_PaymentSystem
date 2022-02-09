package com.example.api_bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class ProductDB  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10)
    private String name;

    @ManyToOne
    private CategoryDB categoryDB;

    @Column(length = 20)
    private String description;

    @Column(precision = 6, scale = 2)
    private double price;

    @Column(length = 1024)
    private String photo;
}

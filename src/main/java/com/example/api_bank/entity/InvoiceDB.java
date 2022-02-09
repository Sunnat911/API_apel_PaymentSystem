package com.example.api_bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class InvoiceDB  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private OrderDB orderDB;

    @Column(nullable = false, precision = 8, scale = 2)
    private double amount;

    private LocalDate issued;

    @Column(nullable = false)
    private LocalDate due;


}

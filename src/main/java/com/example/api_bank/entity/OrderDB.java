package com.example.api_bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDB  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    private CustomerDB customerDB;

    public OrderDB(LocalDate date, CustomerDB customerDB) {
        this.date = date;
        this.customerDB = customerDB;
    }
}

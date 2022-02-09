package com.example.api_bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DetailDB  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private OrderDB orderDB;

    @ManyToOne
    private ProductDB productDB;

    @Column(nullable = false)
    private short quantity;

    public DetailDB(OrderDB orderDB, ProductDB productDB, short quantity) {
        this.orderDB = orderDB;
        this.productDB = productDB;
        this.quantity = quantity;
    }
}

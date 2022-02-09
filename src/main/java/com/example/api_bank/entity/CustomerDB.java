package com.example.api_bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 14)
    private String name;

    @Column(nullable = false, length = 3)
    private String country;

    private String address;

    @Column(length = 50)
    private String phoneNumber;
}

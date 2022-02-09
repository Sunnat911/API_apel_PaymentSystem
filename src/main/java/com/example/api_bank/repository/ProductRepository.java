package com.example.api_bank.repository;

import com.example.api_bank.entity.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductDB,Long> {
    Optional<String> findByName(String productName);

    Optional<ProductDB> findById(Long productId);
}

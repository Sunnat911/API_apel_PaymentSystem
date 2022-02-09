package com.example.api_bank.repository;

import com.example.api_bank.entity.PaymentDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDB,Long> {
}

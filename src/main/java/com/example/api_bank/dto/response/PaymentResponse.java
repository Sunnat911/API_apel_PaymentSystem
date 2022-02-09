package com.example.api_bank.dto.response;

import com.example.api_bank.entity.InvoiceDB;
import com.example.api_bank.entity.PaymentDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse {
    private String paymentStatus;
    private Timestamp time;
    private Double amount;
    private Long invId;

}

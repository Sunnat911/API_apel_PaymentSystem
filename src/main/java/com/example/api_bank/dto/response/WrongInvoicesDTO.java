package com.example.api_bank.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WrongInvoicesDTO {
    private Long invoiceId;
    private LocalDate invoiceIssuedDate;
    private Long orderId;
    private LocalDate orderDate;
}

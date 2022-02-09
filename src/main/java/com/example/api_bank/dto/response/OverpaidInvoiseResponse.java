package com.example.api_bank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverpaidInvoiseResponse {
    private Long invID;
    private  Double amount;

}

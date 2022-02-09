package com.example.api_bank.dto.receiveDTO;

import lombok.Data;

@Data
public class OrderDTO {
    private Long customerId;
    private Long productId;
    private Short quantity;
}

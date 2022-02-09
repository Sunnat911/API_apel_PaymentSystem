package com.example.api_bank.dto.receiveDTO;

import lombok.Data;

@Data
public class CustomerIdAndProductIdAndQuantity {

    private Long cutomerId;

    private Long productId;

    private int quantity;
}

package com.example.api_bank.controller;

import com.example.api_bank.dto.response.PaymentResponse;
import com.example.api_bank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public HttpEntity<?> makePayment(@RequestParam Long invoiceId){
        PaymentResponse paymentResponse = paymentService.makePayment(invoiceId);
        return ResponseEntity.status(paymentResponse.getPaymentStatus().equals("SUCCESS")?201:409).body(paymentResponse);
    }

    @GetMapping("/details")
    public void getPaymentDetails(@RequestParam Long payment_details_id){

    }

}

package com.example.api_bank.controller;

import com.example.api_bank.dto.receiveDTO.OrderDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.dto.response.OrderResponse;
import com.example.api_bank.entity.OrderDB;
import com.example.api_bank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public HttpEntity<?> makeOrder(@RequestBody OrderDTO orderDTO){
        OrderResponse orderResponse = orderService.makeOrder(orderDTO);
        return ResponseEntity.status(orderResponse.getStatus().equals("SUCCESS")?201:409).body(orderResponse);
    }

    @GetMapping
    public HttpEntity<?> getOrderDetailsById(@RequestParam Long orderId){
        ApiResponse apiResponse = orderService.getOrderDetailsById(orderId);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/without_details")
    public List<OrderDB> getOrderWithoutDetails(){
      return orderService.getOrderWithoutDetails();
    }
}

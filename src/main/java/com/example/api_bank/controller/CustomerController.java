package com.example.api_bank.controller;

import com.example.api_bank.dto.receiveDTO.CustomerDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.dto.response.CustomersLastOrdersDTO;
import com.example.api_bank.entity.CustomerDB;
import com.example.api_bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public HttpEntity addCustomer(@RequestBody CustomerDTO customerDTO){
        ApiResponse apiResponse = customerService.addCustomer(customerDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/without_orders")
    public List<CustomerDB> customersWithoutOrders(){
        return customerService.customersWithoutOrders();
    }

    @GetMapping("/last_orders")
    public List<CustomersLastOrdersDTO> customersLastOrders(){
        return customerService.customersLastOrders();
    }
}

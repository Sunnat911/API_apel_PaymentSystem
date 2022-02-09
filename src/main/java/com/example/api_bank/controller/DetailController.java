package com.example.api_bank.controller;

import com.example.api_bank.dto.response.HighProductsResponse;
import com.example.api_bank.dto.response.WrongInvoicesDTO;
import com.example.api_bank.service.DetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/getHighProduct")
    public List<HighProductsResponse> getHighProduct(){
        return detailService.highProducts();
    }


}

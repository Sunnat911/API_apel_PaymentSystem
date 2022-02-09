package com.example.api_bank.controller;

import com.example.api_bank.dto.response.WrongInvoicesDTO;
import com.example.api_bank.entity.InvoiceDB;
import com.example.api_bank.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/expired_invoices")
    public List<InvoiceDB> getExpiredInvoices(){
        return invoiceService.getExpiredInvoices();
    }

    @GetMapping("/wrong_date_invoices")
    public List<WrongInvoicesDTO> getWrongDateInvoices(){
        return invoiceService.getWrongDateInvoices();
    }
}

package com.example.api_bank.service;

import com.example.api_bank.dto.response.WrongInvoicesDTO;
import com.example.api_bank.entity.InvoiceDB;
import com.example.api_bank.entity.OrderDB;
import com.example.api_bank.repository.InvoiceRepository;
import com.example.api_bank.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<InvoiceDB> getExpiredInvoices() {
        return  invoiceRepository.findAllByIssuedAfterDue();
    }

    public List<WrongInvoicesDTO> getWrongDateInvoices() {
        List<InvoiceDB> wrongDateInvoices = invoiceRepository.getWrongDateInvoices();
        return wrongDateInvoices.stream().map(invoice -> {
            Optional<OrderDB> optionalOrderDB = orderRepository.findById(invoice.getOrderDB().getId());
            if (optionalOrderDB.isPresent()) {
                OrderDB order = optionalOrderDB.get();
                WrongInvoicesDTO wrongInvoicesDTO = new WrongInvoicesDTO();
                wrongInvoicesDTO.setInvoiceId(invoice.getId());
                wrongInvoicesDTO.setInvoiceIssuedDate(invoice.getIssued());
                wrongInvoicesDTO.setOrderDate(order.getDate());
                wrongInvoicesDTO.setOrderId(order.getId());
                return wrongInvoicesDTO;
            }
            return null;
        }).collect(Collectors.toList());
    }
}

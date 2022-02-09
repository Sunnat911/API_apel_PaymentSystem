package com.example.api_bank.service;


import com.example.api_bank.dto.response.PaymentResponse;
import com.example.api_bank.entity.InvoiceDB;
import com.example.api_bank.entity.PaymentDB;
import com.example.api_bank.enums.StatusEnum;
import com.example.api_bank.repository.InvoiceRepository;
import com.example.api_bank.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public PaymentResponse makePayment(Long invoiceId) {
        Optional<InvoiceDB> optionalInvoiceDB = invoiceRepository.findById(invoiceId);
        if(optionalInvoiceDB.isEmpty())
            return new PaymentResponse(StatusEnum.FAILED.name(), null, null, null);
        InvoiceDB invoiceDB = optionalInvoiceDB.get();

        PaymentDB paymentDB = new PaymentDB();
        paymentDB.setAmount(invoiceDB.getAmount());
        paymentDB.setInvoiceDB(invoiceDB);
        paymentDB = paymentRepository.save(paymentDB);

        invoiceDB.setIssued(LocalDate.now());
        invoiceRepository.save(invoiceDB);

        return new PaymentResponse(StatusEnum.SUCCESS.name()
                ,paymentDB.getTime()
                ,paymentDB.getAmount()
                ,invoiceDB.getId());
    }

}

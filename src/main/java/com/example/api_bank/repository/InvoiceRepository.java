package com.example.api_bank.repository;

import com.example.api_bank.entity.InvoiceDB;
import com.example.api_bank.entity.PaymentDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceDB,Long> {
    @Query(value = "select * from invoicedb " +
                    "where issued>due", nativeQuery = true)
    List<InvoiceDB> findAllByIssuedAfterDue();

    @Query(value = "select i.* " +
                    "from orderdb o join invoicedb i " +
                    "on o.id = i.orderdb_id " +
                    "where i.issued<=o.date", nativeQuery = true)
    List<InvoiceDB> getWrongDateInvoices();
}


//select * from invoicedb where issued<due
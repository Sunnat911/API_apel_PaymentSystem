package com.example.api_bank.repository;

import com.example.api_bank.dto.response.HighProductsResponse;
import com.example.api_bank.entity.DetailDB;
import com.example.api_bank.entity.InvoiceDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DetailsRepository extends JpaRepository<DetailDB,Long> {
    Optional<DetailDB> findByOrderDB_Id(Long orderDB_id);



    @Query(value = "select d.quantity,d.productdb_id " +
                    "from detaildb d " +
                    "where quantity>=10",nativeQuery = true)
   List<HighProductsResponse> highProduct ();
}

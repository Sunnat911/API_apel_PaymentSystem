package com.example.api_bank.repository;

import com.example.api_bank.entity.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderDB,Long> {
    Optional<OrderDB> findById(Long orderId);

    @Query(value = "select o.* from orderdb o left join detaildb d " +
                    "on o.id=d.orderdb_id " +
                    "where d.id is null and o.date<'2016-09-06'::date", nativeQuery = true)
    List<OrderDB> getOrdersWithoutDetails();
}

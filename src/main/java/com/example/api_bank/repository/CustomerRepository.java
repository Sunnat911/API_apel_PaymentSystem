package com.example.api_bank.repository;

import com.example.api_bank.dto.response.CustomersLastOrdersDTO;
import com.example.api_bank.entity.CustomerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerDB,Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "select distinct c.* " +
                    "from customerdb c left join orderdb o " +
                    "on c.id = o.customerdb_id " +
                    "where extract(years from o.date)<>2016 or o.date is null", nativeQuery = true)
    List<CustomerDB> getAllCustomersWithoutOrders();

    @Query(value =  "select c.id, c.name, o.date " +
                    "from customerdb c join orderdb o " +
                    "on c.id = customerdb_id " +
                    "where o.date = (select max(date) " +
                    "from orderdb where c.id = customerdb_id)", nativeQuery = true)
    List<CustomersLastOrdersDTO> getCustomersLastOrders();

    @Query(value = "select i.id, p.amount " +
                    "from invoisedb i left join paymentdb p " +
                    "on i.id = invoise_id",nativeQuery= true)
    List<CustomerDB>getCustomerDBBy();
}

package com.example.api_bank.service;

import com.example.api_bank.dto.receiveDTO.CustomerDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.dto.response.CustomersLastOrdersDTO;
import com.example.api_bank.entity.CustomerDB;
import com.example.api_bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements BaseService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ApiResponse addCustomer(CustomerDTO customerDTO){
        try{
            //if customer phone number is unique
            if(customerRepository.existsByPhoneNumber(customerDTO.getPhoneNumber()))
                return CUSTOMER_PHONE_NUMBER_EXIST;
            //***************
            CustomerDB customerDB = new CustomerDB();
            customerDB.setName(customerDTO.getName());
            customerDB.setCountry(customerDTO.getCountry());
            customerDB.setAddress(customerDTO.getAddress());
            customerDB.setPhoneNumber(customerDTO.getPhoneNumber());
            customerDB = customerRepository.save(customerDB);
            SUCCESS.setData(customerDB);
            return SUCCESS;
        }catch (Exception e){
            return new ApiResponse(e.getMessage(),false );
        }
    }

    public List<CustomerDB> customersWithoutOrders() {
        return customerRepository.getAllCustomersWithoutOrders();
    }

    public List<CustomersLastOrdersDTO> customersLastOrders() {
        return customerRepository.getCustomersLastOrders();
    }
}

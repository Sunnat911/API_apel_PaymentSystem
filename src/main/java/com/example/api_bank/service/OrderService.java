package com.example.api_bank.service;

import com.example.api_bank.dto.receiveDTO.OrderDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.dto.response.OrderResponse;
import com.example.api_bank.entity.*;
import com.example.api_bank.enums.StatusEnum;
import com.example.api_bank.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements BaseService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final InvoiceRepository invoiceRepository;
    private final DetailsRepository detailsRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository, InvoiceRepository invoiceRepository, DetailsRepository detailsRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
        this.detailsRepository = detailsRepository;
    }

    public ApiResponse getOrderDetailsById(Long orderId) {
        Optional<OrderDB> optionalOrderDB = orderRepository.findById(orderId);
        if(optionalOrderDB.isEmpty())
            return FAILED;
        OrderDB orderDB = optionalOrderDB.get();

        Optional<DetailDB> optionalDetailDB = detailsRepository.findByOrderDB_Id(orderDB.getId());
        if(optionalDetailDB.isEmpty())
            return FAILED;


        return SUCCESS;
    }

        @Transactional
        public OrderResponse makeOrder(OrderDTO orderDTO){
        Optional<CustomerDB> optionalCustomerDB = customerRepository.findById(orderDTO.getCustomerId());
        if(optionalCustomerDB.isEmpty())
            return new OrderResponse(StatusEnum.FAILED.name(), null);

        Optional<ProductDB> optionalProductDB = productRepository.findById(orderDTO.getProductId());
        if(optionalProductDB.isEmpty())
            return new OrderResponse(StatusEnum.FAILED.name(), null);
            ProductDB productDB = optionalProductDB.get();

        OrderDB orderDB = new OrderDB(LocalDate.now(), optionalCustomerDB.get());
        orderDB = orderRepository.save(orderDB);

        DetailDB detailDB = new DetailDB(orderDB, productDB, orderDTO.getQuantity());
        detailsRepository.save(detailDB);

        InvoiceDB invoiceDB = new InvoiceDB();
        invoiceDB.setOrderDB(orderDB);
        invoiceDB.setAmount(productDB.getPrice()* orderDTO.getQuantity());
        invoiceDB.setDue(LocalDate.now().plusDays(10));
        invoiceDB =  invoiceRepository.save(invoiceDB);

        return new OrderResponse(StatusEnum.SUCCESS.name(), invoiceDB.getId());
    }

    public List<OrderDB> getOrderWithoutDetails() {
        return orderRepository.getOrdersWithoutDetails();
    }
}

package com.example.api_bank.service;

import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.dto.response.OrderResponse;

public interface BaseService {

    ApiResponse SUCCESS = new ApiResponse("success",true,0);
    ApiResponse FAILED = new ApiResponse("failed", false);
    ApiResponse SUCCESS_ADDED_CATEGORY = new ApiResponse("CATEGORY WAS ADDED",true,0);
    ApiResponse CATEGORY_EXIST = new ApiResponse("category exist",false,-100);
    ApiResponse PRODUCT_EXIST = new ApiResponse("product like tish name exist",false,-100);
    ApiResponse ORDER_EXIST = new ApiResponse("order_exist",false,-100);
    ApiResponse CUSTOMER_PHONE_NUMBER_EXIST = new ApiResponse("Customer_phone_number_exist",false,-100);

}

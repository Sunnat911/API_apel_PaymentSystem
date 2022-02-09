package com.example.api_bank.controller;

import com.example.api_bank.dto.receiveDTO.ProductDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    private HttpEntity<?> addProduct(@RequestBody ProductDTO receiveProductDto){
        ApiResponse apiResponse = productService.addProduct(receiveProductDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/list")
    private HttpEntity<?> getProductList() {
        ApiResponse apiResponse = productService.getProductList();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?>getProductDetailsById(@RequestParam Long product_id){
        ApiResponse apiResponse = productService.getProductDetailsById(product_id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
}


}

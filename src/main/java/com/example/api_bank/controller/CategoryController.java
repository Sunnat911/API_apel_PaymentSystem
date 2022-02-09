package com.example.api_bank.controller;

import com.example.api_bank.dto.receiveDTO.CategoryDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.repository.ProductRepository;
import com.example.api_bank.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public CategoryController(CategoryService categoryService, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }



    @PostMapping
     public HttpEntity<?> addCategory(@RequestBody CategoryDTO receiveCategoryDto){
        ApiResponse apiResponse = categoryService.addCategory(receiveCategoryDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);

}
    @GetMapping("/list")
    public HttpEntity<?> getCategoryList(){
        ApiResponse apiResponse = categoryService.getCategoryList();
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }


    @GetMapping
    public HttpEntity<?>getCategoryDetailsByProductId(@RequestParam Long product_id){
        ApiResponse apiResponse = categoryService.getCategoryDetailsByProductId(product_id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

}


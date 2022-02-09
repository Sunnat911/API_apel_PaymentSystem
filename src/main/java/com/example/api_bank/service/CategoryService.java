package com.example.api_bank.service;

import com.example.api_bank.dto.receiveDTO.CategoryDTO;
import com.example.api_bank.dto.response.ApiResponse;
import com.example.api_bank.entity.CategoryDB;
import com.example.api_bank.entity.ProductDB;
import com.example.api_bank.repository.CategoryRepository;
import com.example.api_bank.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements BaseService {
    @Autowired
    public final CategoryRepository categoryRepository;
    public final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public ApiResponse addCategory(CategoryDTO receiveCategoryDto) {
        Optional<String> byName = categoryRepository.findByName(receiveCategoryDto.getName());
        if(byName.isPresent())
            return CATEGORY_EXIST;

             CategoryDB categoryDB = new CategoryDB();
             categoryDB.setName(receiveCategoryDto.getName());
             categoryRepository.save(categoryDB);

             SUCCESS.setData(categoryDB);

       return SUCCESS_ADDED_CATEGORY;
    }

    public ApiResponse getCategoryList() {
        List<CategoryDB> allCategoryList = categoryRepository.findAll();
        SUCCESS.setData(allCategoryList);
        return SUCCESS;
    }



    public ApiResponse getCategoryDetailsByProductId(Long productId) {
        Optional<ProductDB> productDB = productRepository.findById(productId);
        if(productDB.isEmpty())
            return PRODUCT_EXIST;

        CategoryDB categoryDB = productDB.get().getCategoryDB();
        SUCCESS.setData(categoryDB);

        return SUCCESS;
    }
}

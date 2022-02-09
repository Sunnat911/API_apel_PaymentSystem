package com.example.api_bank.service;

import com.example.api_bank.dto.receiveDTO.ProductDTO;
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
public class ProductService implements BaseService{
    @Autowired
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ApiResponse addProduct(ProductDTO receiveProductDto){
        Optional<CategoryDB> categoryDB = categoryRepository.findById(receiveProductDto.getCategoryId());
        if(categoryDB.isEmpty())
            return CATEGORY_EXIST;
        ProductDB productDB = new ProductDB();
        productDB.setName(receiveProductDto.getName());
        productDB.setPrice(receiveProductDto.getPrice());
        productDB.setCategoryDB(categoryDB.get());

        productRepository.save(productDB);
        SUCCESS.setData(categoryDB);

        return SUCCESS;
}

    public ApiResponse getProductList() {
        List<ProductDB> allProduct = productRepository.findAll();

        SUCCESS.setData(allProduct);
        return SUCCESS;
    }

    public ApiResponse getProductDetailsById(Long productId) {
        Optional<ProductDB> productDetails = productRepository.findById(productId);
        SUCCESS.setData(productDetails);

        return SUCCESS;
    }



}

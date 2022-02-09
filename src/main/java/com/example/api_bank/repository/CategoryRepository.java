package com.example.api_bank.repository;

import com.example.api_bank.entity.CategoryDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryDB,Long> {
    Optional<String> findByName(String  categoryName);
    Optional<CategoryDB> findById(Long categoryId);



}

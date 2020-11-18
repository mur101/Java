package com.example.repository;

import com.example.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
    List<ProductCategory>findByProductCategoryId(Long productCategoryId);
}


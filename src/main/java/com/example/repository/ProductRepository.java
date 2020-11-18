package com.example.repository;

import com.example.domain.ProductCategory;
import com.example.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{
    List<Products> findByProductId (Long productId);
    List<Products> findByProductNameStartingWithIgnoreCase(String productName);
}


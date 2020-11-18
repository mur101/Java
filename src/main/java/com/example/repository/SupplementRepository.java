package com.example.repository;

import com.example.domain.Products;
import com.example.domain.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplementRepository extends JpaRepository<Supplements, Long>{
    List<Supplements> findBySupplementId (Long SupplementId);
    List<Supplements> findBySupplementCodeStartingWithIgnoreCase(String SupplementCode);
}


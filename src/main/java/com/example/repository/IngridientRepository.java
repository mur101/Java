package com.example.repository;

import com.example.domain.Ingridients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngridientRepository extends JpaRepository<Ingridients, Long>{
}


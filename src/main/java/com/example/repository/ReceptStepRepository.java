package com.example.repository;

import com.example.domain.ReceptSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptStepRepository extends JpaRepository<ReceptSteps, Long>{
}


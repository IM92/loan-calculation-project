package com.calculator.price.repository;

import com.calculator.price.model.LoanInfoCalculated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanInfoCalculatedRepository extends JpaRepository<LoanInfoCalculated, String> {
}

package com.calculator.price.repository;

import com.calculator.price.model.LoanInfoCalculated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface LoanInfoCalculatedRepository extends JpaRepository<LoanInfoCalculated, String> {
}

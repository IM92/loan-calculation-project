package com.calculator.price.repository;

import com.calculator.price.model.LoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanInfoRepository extends JpaRepository<LoanInfo, String> {

}

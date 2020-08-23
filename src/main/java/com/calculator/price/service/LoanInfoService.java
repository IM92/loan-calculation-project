package com.calculator.price.service;

import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;

public interface LoanInfoService extends OptionalDomainService<LoanInfoCalculated> {

    LoanInfo createLoanInfo(LoanInfo loanInfo);

    LoanInfoCalculated createLoanInfoCalculated(LoanInfoCalculated loanInfoCalculated);

}

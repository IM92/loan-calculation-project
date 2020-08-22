package com.calculator.price.service;


import com.calculator.price.model.ItemInfo;
import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;

public interface LoanInfoService extends OptionalDomainService<LoanInfo>{

    LoanInfo createLoanInfo(LoanInfo loanInfo);

    LoanInfoCalculated createLoanInfoCalculated(LoanInfoCalculated loanInfoCalculated);

    ItemInfo createItemInfo(ItemInfo itemInfo);
}

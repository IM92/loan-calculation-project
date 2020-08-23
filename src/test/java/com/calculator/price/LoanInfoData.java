package com.calculator.price;

import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;

import java.math.BigDecimal;

public class LoanInfoData {

    public static LoanInfo createLoanInfo() {
        LoanInfo loanInfo = new LoanInfo();
        //loanInfo.setId("1");
        loanInfo.setAmount(BigDecimal.valueOf(1000));
        loanInfo.setNumberOfMonths(BigDecimal.valueOf(10));
        loanInfo.setAnnualInterestPercent(BigDecimal.valueOf(5));
        return loanInfo;
    }

    public static LoanInfoCalculated createLoanInfoCalculated(){
        LoanInfoCalculated calculated = new LoanInfoCalculated();
        calculated.setLoanInfo(createLoanInfo());
        calculated.setInterestAmount(BigDecimal.valueOf(23.1));
        calculated.setTotalAmount(BigDecimal.valueOf(1023.1));
        calculated.setAmount(BigDecimal.valueOf(1000));
        return calculated;
    }
}

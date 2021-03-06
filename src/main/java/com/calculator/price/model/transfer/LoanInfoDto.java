package com.calculator.price.model.transfer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class LoanInfoDto{

    private BigDecimal amount;
    private BigDecimal numberOfMonths;
    private BigDecimal annualInterestPercent;
}

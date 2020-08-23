package com.calculator.price.controller.facade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class LoanInfoRequest {

    private BigDecimal amount;
    private BigDecimal numberOfMonths;
    private BigDecimal annualInterestPercent;
}

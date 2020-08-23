package com.calculator.price.model.transfer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class LoanCalculatedDto  {
    private BigDecimal amount;
    private BigDecimal totalAmount;
    private BigDecimal interestAmount;
}

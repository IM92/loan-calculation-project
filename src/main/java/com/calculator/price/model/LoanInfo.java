package com.calculator.price.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "LOAN_INFO")
@Getter
@Setter
public class LoanInfo extends AbstractBaseEntity {

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "number_of_months")
    private BigDecimal numberOfMonths;

    @Column(name = "annual_interest_percent")
    private BigDecimal annualInterestPercent;

}

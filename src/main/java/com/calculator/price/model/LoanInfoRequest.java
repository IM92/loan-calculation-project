package com.calculator.price.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanInfoRequest implements Serializable {

    private static final long serialVersionUID = 8195267538799131044L;

    private BigDecimal amount;
    private BigDecimal numberOfMonths;
    private BigDecimal annualInterestPercent;
}

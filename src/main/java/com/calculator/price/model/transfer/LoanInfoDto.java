package com.calculator.price.model.transfer;

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
public class LoanInfoDto implements Serializable {
    private static final long serialVersionUID = -6686685961535375070L;

    private BigDecimal amount;
    private BigDecimal numberOfMonths;
    private BigDecimal annualInterestPercent;
}

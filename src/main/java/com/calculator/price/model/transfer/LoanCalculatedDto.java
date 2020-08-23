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
public class LoanCalculatedDto implements Serializable {

    private static final long serialVersionUID = -2248469238393032894L;
    private BigDecimal amount;
    private BigDecimal totalAmount;
    private BigDecimal interestAmount;

}

package com.calculator.price.model.transfer;

import com.calculator.price.model.ItemInfo;
import com.calculator.price.model.LoanInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

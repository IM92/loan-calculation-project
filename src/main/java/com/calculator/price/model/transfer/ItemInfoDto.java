package com.calculator.price.model.transfer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class ItemInfoDto implements Serializable {
    private BigDecimal month;
    private BigDecimal paymentAmount;
}

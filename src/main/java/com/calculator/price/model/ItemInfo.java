package com.calculator.price.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM_INFO")
@Getter
@Setter
public class ItemInfo extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "loan_info_calculated_id")
    private LoanInfoCalculated loanInfoCalculated;

    @Column(name = "month")
    private BigDecimal month;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;
}

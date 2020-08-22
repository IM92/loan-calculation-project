package com.calculator.price.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOAN_INFO_CALCULATED")
@Getter
@Setter
public class LoanInfoCalculated extends AbstractBaseEntity {

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "interest_mount")
    private BigDecimal interestAmount;

    @OneToMany(mappedBy = "loanInfoCalculated")
    private List<ItemInfo> itemInfoList = new ArrayList<>();
}

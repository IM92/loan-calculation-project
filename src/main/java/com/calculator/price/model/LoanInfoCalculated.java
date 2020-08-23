package com.calculator.price.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "LOAN_INFO_CALCULATED")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanInfoCalculated extends AbstractBaseEntity {

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "interest_mount")
    private BigDecimal interestAmount;

    @OneToOne
    @JoinColumn(name = "loan_info_id")
    private LoanInfo loanInfo;

}

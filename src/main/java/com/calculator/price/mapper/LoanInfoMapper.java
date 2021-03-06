package com.calculator.price.mapper;

import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;
import com.calculator.price.controller.facade.LoanInfoRequest;
import com.calculator.price.model.transfer.LoanCalculatedDto;
import com.calculator.price.model.transfer.LoanInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface LoanInfoMapper {

    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "numberOfMonths", source = "numberOfMonths")
    @Mapping(target = "annualInterestPercent", source = "annualInterestPercent")
    LoanInfoDto mapToLoanInfoDto(LoanInfoRequest loanInfoRequest);

    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "numberOfMonths", source = "numberOfMonths")
    @Mapping(target = "annualInterestPercent", source = "annualInterestPercent")
    LoanInfo mapToLoanInfo(LoanInfoDto loanInfoDto);

    LoanCalculatedDto mapToLoanCalculatedDto(LoanInfoCalculated loanInfoCalculated);

    LoanInfoCalculated mapToLoanCalculated(LoanCalculatedDto loanCalculatedDto);
}

package com.calculator.price.controller;

import com.calculator.price.mapper.LoanInfoMapper;
import com.calculator.price.model.*;
import com.calculator.price.model.transfer.ItemInfoDto;
import com.calculator.price.model.transfer.LoanCalculatedDto;
import com.calculator.price.model.transfer.LoanInfoDto;
import com.calculator.price.service.LoanInfoService;
import com.calculator.price.validation.LoanInfoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
@Slf4j
public class LoanInfoFacadeImpl implements LoanInfoFacade {

    private final LoanInfoService loanInfoService;
    private final LoanInfoValidator loanInfoValidator;
    private final LoanInfoMapper loanInfoMapper;

    @Autowired
    public LoanInfoFacadeImpl(LoanInfoService loanInfoService,
                              LoanInfoValidator loanInfoValidator,
                              LoanInfoMapper loanInfoMapper) {
        this.loanInfoService = loanInfoService;
        this.loanInfoValidator = loanInfoValidator;
        this.loanInfoMapper = loanInfoMapper;
    }

    @Override
    public LoanInfoResponse createLoanInfos(final LoanInfoRequest loanInfoRequest) {
        this.loanInfoValidator.validationLoanInfo(loanInfoRequest);

        LoanInfoDto loanInfoDto = loanInfoMapper.mapToLoanInfoDto(loanInfoRequest);
        LoanInfo loanInfo = loanInfoMapper.mapToLoanInfo(loanInfoDto);

        if(Objects.nonNull(loanInfo)) {
            loanInfoService.createLoanInfo(loanInfo);
        }

        BigDecimal interestAmount = (loanInfoDto.getAnnualInterestPercent()
                .divide(BigDecimal.valueOf(100)))
                .divide(BigDecimal.valueOf(12),6, RoundingMode.HALF_UP);

        BigDecimal numberOfMonths = loanInfoDto.getNumberOfMonths();
        BigDecimal totalAmount = loanInfoDto.getAmount();

        BigDecimal result = BigDecimal.ONE.add(interestAmount);

        BigDecimal finalResult = result.pow(numberOfMonths.intValue()).setScale(6, RoundingMode.HALF_UP);
        BigDecimal totalAmountPayment = totalAmount.multiply(interestAmount).multiply((finalResult).setScale(6, RoundingMode.HALF_UP)).setScale(6,RoundingMode.HALF_UP);
        BigDecimal divideTotalAmount =  ((finalResult).subtract(BigDecimal.valueOf(1))).setScale(6,RoundingMode.HALF_UP);

        BigDecimal totalPayment = totalAmountPayment.divide(divideTotalAmount,2,RoundingMode.HALF_DOWN);

        BigDecimal amount = totalPayment.multiply(numberOfMonths).setScale(3,RoundingMode.HALF_DOWN);
        BigDecimal finalInterestAmount = amount.subtract(totalAmount).setScale(2,RoundingMode.HALF_DOWN);

        int number = numberOfMonths.intValue();
        List<ItemInfoDto> itemInfoDtoList = new ArrayList<>();

        LoanCalculatedDto calculatedDto = new LoanCalculatedDto();
        calculatedDto.setAmount(totalAmount);
        calculatedDto.setTotalAmount(amount);
        calculatedDto.setInterestAmount(finalInterestAmount);


        LoanInfoCalculated loanInfoCalculated = loanInfoMapper.mapToLoanCalculated(calculatedDto);

        if(Objects.nonNull(loanInfoCalculated)) {
            loanInfoService.createLoanInfoCalculated(loanInfoCalculated);
        }


        for(int i = 0; i < number; i ++){
            ItemInfoDto itemInfoDto = new ItemInfoDto();
            itemInfoDto.setMonth(BigDecimal.valueOf(i+1));
            itemInfoDto.setPaymentAmount(totalPayment);
            itemInfoDtoList.add(itemInfoDto);
        }

//        if(Objects.nonNull(itemInfo)){
//            loanInfoService.createItemInfo(itemInfo);
//        }

        return new LoanInfoResponse(calculatedDto,itemInfoDtoList);
    }

}

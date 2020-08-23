package com.calculator.price.controller.facade;

import com.calculator.price.controller.LoanInfoController;
import com.calculator.price.exceptions.CoreInvalidDataException;
import com.calculator.price.mapper.LoanInfoMapper;
import com.calculator.price.model.*;
import com.calculator.price.model.transfer.ItemInfoDto;
import com.calculator.price.model.transfer.LoanCalculatedDto;
import com.calculator.price.model.transfer.LoanInfoDto;
import com.calculator.price.service.LoanInfoService;
import com.calculator.price.validation.LoanInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class LoanInfoFacadeImpl implements LoanInfoFacade {

    private final Logger logger = LoggerFactory.getLogger(LoanInfoFacadeImpl.class);

    private final BigDecimal PERCENTAGE = new BigDecimal(100);
    private final BigDecimal NUMBER_OF_MONTH = new BigDecimal(12);
    private final BigDecimal ONE_VALUE = new BigDecimal(1);
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
    public LoanInfoResponse createCalculatedLoanInfo(final LoanInfoRequest loanInfoRequest) {
        logger.debug("Get create calculated loan");
        this.loanInfoValidator.validationLoanInfo(loanInfoRequest);

        LoanInfoDto loanInfoDto = loanInfoMapper.mapToLoanInfoDto(loanInfoRequest);
        LoanInfo loanInfo = loanInfoMapper.mapToLoanInfo(loanInfoDto);

        if(Objects.nonNull(loanInfo)) {
            loanInfoService.createLoanInfo(loanInfo);
        }
        logger.debug("Create calculated loan is created");
        BigDecimal interestAmount = (loanInfoDto.getAnnualInterestPercent()
                .divide(PERCENTAGE))
                .divide(NUMBER_OF_MONTH,6, RoundingMode.HALF_UP);

        BigDecimal numberOfMonths = loanInfoDto.getNumberOfMonths();
        BigDecimal totalAmount = loanInfoDto.getAmount();

        BigDecimal result = BigDecimal.ONE.add(interestAmount);

        BigDecimal finalResult = result.pow(numberOfMonths.intValue()).setScale(6, RoundingMode.HALF_UP);
        BigDecimal totalAmountPayment = totalAmount.multiply(interestAmount).multiply((finalResult).setScale(6, RoundingMode.HALF_UP)).setScale(6,RoundingMode.HALF_UP);
        BigDecimal divideTotalAmount =  ((finalResult).subtract(ONE_VALUE)).setScale(6,RoundingMode.HALF_UP);

        BigDecimal totalPayment = totalAmountPayment.divide(divideTotalAmount,2,RoundingMode.HALF_DOWN);

        BigDecimal amount = totalPayment.multiply(numberOfMonths).setScale(3,RoundingMode.HALF_DOWN);
        BigDecimal finalInterestAmount = amount.subtract(totalAmount).setScale(2,RoundingMode.HALF_DOWN);
        logger.debug("Calculation has finished");

        int number = numberOfMonths.intValue();
        List<ItemInfoDto> itemInfoDtoList = new ArrayList<>();

        LoanInfoCalculated loanInfoCalculated = LoanInfoCalculated.builder()
                .amount(totalAmount)
                .totalAmount(amount)
                .interestAmount(finalInterestAmount)
                .loanInfo(loanInfo)
                .build();

        this.loanInfoValidator.validationLoanInfoCalculated(loanInfoCalculated);

        if(Objects.nonNull(loanInfoCalculated)) {
            loanInfoService.createLoanInfoCalculated(loanInfoCalculated);
        }
        LoanCalculatedDto calculatedDto = loanInfoMapper.mapToLoanCalculatedDto(loanInfoCalculated);

        for(int i = 0; i < number; i ++){
            ItemInfoDto itemInfoDto = ItemInfoDto.builder()
                    .month(BigDecimal.valueOf(i+1))
                    .paymentAmount(totalPayment)
                    .build();
            itemInfoDtoList.add(itemInfoDto);
        }
        return new LoanInfoResponse(calculatedDto,itemInfoDtoList);
    }

}

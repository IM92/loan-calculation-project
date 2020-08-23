package com.calculator.price.controller;

import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoRequest;
import com.calculator.price.model.LoanInfoResponse;
import com.calculator.price.validation.LoanInfoValidator;
import com.calculator.price.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
public class LoanInfoController {

    private final LoanInfoFacade loanInfoFacade;

    @Autowired
    public LoanInfoController(final LoanInfoFacade loanInfoFacade) {
        this.loanInfoFacade = loanInfoFacade;
    }

    @RequestMapping(
            value = "/secure/loanInfo/installment-plan",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LoanInfoResponse> createCalculatedLoanInfo(@RequestBody LoanInfoRequest licenseRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.loanInfoFacade.createCalculatedLoanInfo(licenseRequest));
    }
}

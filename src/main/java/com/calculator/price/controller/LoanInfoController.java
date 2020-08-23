package com.calculator.price.controller;

import com.calculator.price.controller.facade.LoanInfoFacade;
import com.calculator.price.controller.facade.LoanInfoRequest;
import com.calculator.price.controller.facade.LoanInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoanInfoController {

    private final Logger logger = LoggerFactory.getLogger(LoanInfoController.class);

    private final LoanInfoFacade loanInfoFacade;

    @Autowired
    public LoanInfoController(final LoanInfoFacade loanInfoFacade) {
        this.loanInfoFacade = loanInfoFacade;
    }

    @RequestMapping(
            value = "/loanInfo/installment-plan",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LoanInfoResponse> createCalculatedLoanInfo(@RequestBody LoanInfoRequest licenseRequest) {
        logger.info("Triggered loan info calculated POST api");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.loanInfoFacade.createCalculatedLoanInfo(licenseRequest));
    }
}

package com.calculator.price.controller;

import com.calculator.price.model.LoanInfoRequest;
import com.calculator.price.model.LoanInfoResponse;

public interface LoanInfoFacade {

    LoanInfoResponse createLoanInfos(final LoanInfoRequest licenseRequest);

}
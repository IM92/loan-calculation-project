package com.calculator.price.validation;

import com.calculator.price.exceptions.CreateLoanInfoException;
import com.calculator.price.model.LoanInfoRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Component for validating a client corporation entity
 */
@Component
public class LoanInfoValidator {

    public void validationLoanInfo(LoanInfoRequest loanInfoRequest) {
        List<ValidationMessage> messages = new ArrayList<>();
        validateAmount(loanInfoRequest, messages);
        validateNumberOfMonths(loanInfoRequest, messages);
        validateAnnualInterestPercent(loanInfoRequest, messages);

        Validation validation = new Validation(messages.isEmpty(), messages);
        if (!validation.isValid()) {
            throw new CreateLoanInfoException(validation);
        }
    }

    public Validation validationLoanInfoTT(LoanInfoRequest loanInfoRequest) {
        List<ValidationMessage> messages = new ArrayList<>();
        validateAmount(loanInfoRequest, messages);
        validateNumberOfMonths(loanInfoRequest, messages);
        validateAnnualInterestPercent(loanInfoRequest, messages);

        Validation validation = new Validation(messages.isEmpty(), messages);
        if (!validation.isValid()) {
            throw new CreateLoanInfoException(validation);
        }

        return new Validation(messages.isEmpty(), messages);
    }

    private void validateAnnualInterestPercent(LoanInfoRequest loanInfoRequest, List<ValidationMessage> messages) {
        final BigDecimal amount = loanInfoRequest.getAmount();
        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
            messages.add(new ValidationMessage(CommonErrorType.FIELD_AMOUNT));
        }
    }
    private void validateNumberOfMonths(LoanInfoRequest loanInfoRequest, List<ValidationMessage> messages) {
        final BigDecimal numberOfMonths = loanInfoRequest.getNumberOfMonths();
        if (numberOfMonths == null || numberOfMonths.compareTo(BigDecimal.ZERO) == 0) {
            messages.add(new ValidationMessage(CommonErrorType.FIELD_NUMBER_OF_MONTHS));
        }
    }
    private void validateAmount(LoanInfoRequest loanInfoRequest, List<ValidationMessage> messages) {
        final BigDecimal annualInterestPercent = loanInfoRequest.getAnnualInterestPercent();
        if (annualInterestPercent == null || annualInterestPercent.compareTo(BigDecimal.ZERO) == 0) {
            messages.add(new ValidationMessage(CommonErrorType.FIELD_ANNUAL_INTEREST_PERCENT));
        }
    }
}

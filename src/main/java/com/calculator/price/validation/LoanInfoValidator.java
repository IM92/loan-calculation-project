package com.calculator.price.validation;

import com.calculator.price.exceptions.CreateLoanInfoCalculatedException;
import com.calculator.price.exceptions.CreateLoanInfoException;
import com.calculator.price.model.LoanInfoCalculated;
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

    public void validationLoanInfoCalculated(LoanInfoCalculated loanInfoCalculated) {
        List<ValidationMessage> messages = new ArrayList<>();
        validateLCalculatedAmount(loanInfoCalculated, messages);
        validateTotalAmount(loanInfoCalculated, messages);
        validateInterestAmount(loanInfoCalculated, messages);

        Validation validation = new Validation(messages.isEmpty(), messages);
        if (!validation.isValid()) {
            throw new CreateLoanInfoCalculatedException(validation);
        }
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

    private void validateInterestAmount(LoanInfoCalculated loanInfoCalculated, List<ValidationMessage> messages) {
        final BigDecimal interestAmount = loanInfoCalculated.getInterestAmount();
        if (interestAmount == null || interestAmount.compareTo(BigDecimal.ZERO) == 0) {
            messages.add(new ValidationMessage(CommonErrorType.FIELD_INTEREST_AMOUNT));
        }
    }

    private void validateTotalAmount(LoanInfoCalculated loanInfoCalculated, List<ValidationMessage> messages) {
        final BigDecimal totalAmount = loanInfoCalculated.getTotalAmount();
        if (totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) == 0) {
            messages.add(new ValidationMessage(CommonErrorType.FIELD_TOTAL_AMOUNT));
        }
    }

    private void validateLCalculatedAmount(LoanInfoCalculated loanInfoCalculated, List<ValidationMessage> messages) {
        final BigDecimal amount = loanInfoCalculated.getAmount();
        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
            messages.add(new ValidationMessage(CommonErrorType.FIELD_AMOUNT));
        }
    }
}

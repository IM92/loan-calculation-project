package com.calculator.price.validation;

public enum  CommonErrorType implements ErrorType {

    FIELD_AMOUNT("amount", "Amount name is required"),
    FIELD_NUMBER_OF_MONTHS("numberOfMonths", "Number of months is required"),
    FIELD_ANNUAL_INTEREST_PERCENT("annualInterestPercent", "Annual interest percent is required"),
    FIELD_INTEREST_AMOUNT("interestAmount", "Interest amount is required"),
    FIELD_TOTAL_AMOUNT("totalAmount", "Total amount is required");
    private String field;
    private String reason;

    CommonErrorType(String field, String reason) {
        this.field = field;
        this.reason = reason;
    }

    @Override
    public String getType() {
        return this.name();
    }

    public String getField() {
        return this.field;
    }

    @Override
    public String getReason() {
        return reason;
    }
}

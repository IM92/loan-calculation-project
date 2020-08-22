package com.calculator.price.exceptions;

public class ComplexExceptionResponseDTO<T> {

    private T data;
    private String message;
    private ErrorStatus status;


    public ComplexExceptionResponseDTO(T data, String message, ErrorStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public ComplexExceptionResponseDTO(ErrorStatus status){
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }
}


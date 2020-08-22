package com.calculator.price.exceptions;


public class ExceptionResponseDTO<T> {

    private T data;
    private ErrorStatus status;

    public ExceptionResponseDTO(T data, ErrorStatus status) {
        this.data = data;
        this.status = status;
    }

    public ExceptionResponseDTO(ErrorStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }
}

package com.project.exception;

public class APIException extends RuntimeException {
    private String errorMessage;

    public APIException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

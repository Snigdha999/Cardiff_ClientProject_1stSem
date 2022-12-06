package com.project.exception;

import com.project.model.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> constraintViolationHandler(
            ConstraintViolationException constraintViolationException) {
        return new ResponseEntity<>(new ApiResponse("Email Exists"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> DataIntegrityViolationException(
            DataIntegrityViolationException constraintViolationException) {
        return new ResponseEntity<>(new ApiResponse("Email Exists"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ApiResponse> userExceptionHandler(APIException apiException) {
        return new ResponseEntity<>(new ApiResponse(apiException.getErrorMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> genericExceptionHandler(Exception exception) {
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ApiResponse> MissingRequestHeaderExceptionHandler(MissingRequestHeaderException exception) {
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse> MissingServletRequestParameterExceptionHandler(
            MissingServletRequestParameterException exception) {
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse> HttpRequestMethodNotSupportedExceptionHandler(
            HttpRequestMethodNotSupportedException exception) {
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse> HttpMediaTypeNotSupportedExceptionHandler(
            HttpMediaTypeNotSupportedException exception) {
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> HttpMessageNotReadableExceptionHandler(
            HttpMessageNotReadableException exception) {
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

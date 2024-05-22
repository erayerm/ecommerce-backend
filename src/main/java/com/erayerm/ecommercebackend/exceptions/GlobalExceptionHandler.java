package com.erayerm.ecommercebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(ProductException productsException){
        ProductErrorResponse errorResponse = new ProductErrorResponse(productsException.getStatus().value(), productsException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, productsException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(Exception exception){

        ProductErrorResponse errorResponse = new ProductErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

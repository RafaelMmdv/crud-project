package com.project.crudspr.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    public ResponseEntity<?> custopmerNotNull(CustomerNotNullException customerNotNullException){
        List<String> detail = new ArrayList<>();
        detail.add(customerNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Customer Not Null Exception", detail);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

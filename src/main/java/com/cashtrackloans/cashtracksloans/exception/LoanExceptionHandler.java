package com.cashtrackloans.cashtracksloans.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LoanExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { InvalidParamException.class })
    protected ResponseEntity<ErrorResponse> handleInvalidParamException(){
        return ErrorResponse.createResponseEntity(ErrorEnum.INVALID_PARAMETER);
    }

    @ExceptionHandler(value = { NoLoanDataException.class })
    protected ResponseEntity<ErrorResponse> handleNoDataException(){
        return ErrorResponse.createResponseEntity(ErrorEnum.DATA_NOT_FOUND);
    }

}

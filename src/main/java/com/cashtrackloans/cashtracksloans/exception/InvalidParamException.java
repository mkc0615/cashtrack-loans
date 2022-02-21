package com.cashtrackloans.cashtracksloans.exception;

public class InvalidParamException extends BusinessException{

    public InvalidParamException(ErrorEnum errorEnum) {
        super(errorEnum);
    }

}

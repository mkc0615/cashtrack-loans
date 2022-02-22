package com.cashtrackloans.cashtracksloans.exception;

public class NoLoanDataException extends BusinessException{

    public NoLoanDataException(ErrorEnum errorEnum) {
        super(errorEnum);
    }

}

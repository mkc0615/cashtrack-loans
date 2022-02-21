package com.cashtrackloans.cashtracksloans.exception;

public class NoSuchDomainException extends BusinessException{

    public NoSuchDomainException(ErrorEnum errorEnum) {
        super(errorEnum);
    }

}

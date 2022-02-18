package com.cashtrackloans.cashtracksloans.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private final ErrorEnum errorEnum;
}

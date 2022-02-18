package com.cashtrackloans.cashtracksloans.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid parameter"),

    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "No Data Found")

    ;

    private final HttpStatus httpStatus;

    private final String message;
}

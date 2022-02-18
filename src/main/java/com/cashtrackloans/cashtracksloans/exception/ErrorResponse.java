package com.cashtrackloans.cashtracksloans.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponse {

    private final int status;
    private final String message;
    private final String code;
    private final String error;

    public static ResponseEntity<ErrorResponse> createResponseEntity(ErrorEnum errorEnum){
        return ResponseEntity
                .status(errorEnum.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(errorEnum.getHttpStatus().value())
                        .error(errorEnum.getHttpStatus().name())
                        .code(errorEnum.name())
                        .message(errorEnum.getMessage())
                        .build()
                );
    }
}

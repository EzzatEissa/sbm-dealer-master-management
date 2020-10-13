package com.sbm.dealer.common.exception;

import lombok.Data;

@Data
public class ErrorResponse {

    String errorMessage;
    Integer errorCode;

    public ErrorResponse(String errorMessage, Integer errorCode) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ErrorResponse() { }
}

package com.example.UrlShortener.exception;

import lombok.Getter;

@Getter
public class UrlException extends RuntimeException {
    private ErrorCode code;
    private String message;

    public UrlException(ErrorCode errorCode) {
        this.code = errorCode;
        this.message = errorCode.getMessage();
    }

    public UrlException(ErrorCode errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }
}

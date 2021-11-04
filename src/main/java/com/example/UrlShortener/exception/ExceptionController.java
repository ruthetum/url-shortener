package com.example.UrlShortener.exception;

import com.example.UrlShortener.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.UrlShortener.exception.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.example.UrlShortener.exception.ErrorCode.INVALID_REQUEST;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UrlException.class)
    public ErrorResponse handleException(UrlException e) {
        log.error("errorCode : {}, message : {}",
                e.getCode(), e.getMessage());

        return ErrorResponse.builder()
                .status(400)
                .errorCode(e.getCode())
                .errorMessage(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
    })
    public ErrorResponse handleBadRequest(
            Exception e,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        log.error("url : {}, message : {}",
                request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .status(400)
                .errorCode(INVALID_REQUEST)
                .errorMessage(INVALID_REQUEST.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(
            Exception e, HttpServletRequest request
    ) {
        log.error("url : {}, message : {}",
                request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .status(500)
                .errorCode(INTERNAL_SERVER_ERROR)
                .errorMessage(INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}

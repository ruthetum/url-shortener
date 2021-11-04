package com.example.UrlShortener.dto;

import com.example.UrlShortener.exception.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private int status;
    private ErrorCode errorCode;
    private String errorMessage;
}

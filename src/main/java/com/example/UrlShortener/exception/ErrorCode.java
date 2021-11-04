package com.example.UrlShortener.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_URL("URL의 형식이 올바르지 않습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다.");

    private final String message;
}

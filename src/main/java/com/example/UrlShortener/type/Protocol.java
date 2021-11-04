package com.example.UrlShortener.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Protocol {

    HTTP("http://"),
    HTTPS("https://");

    private final String prefix;
}

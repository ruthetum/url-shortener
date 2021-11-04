package com.example.UrlShortener.dto;

import com.example.UrlShortener.config.EnvConfig;
import com.example.UrlShortener.entity.Url;
import lombok.*;

import javax.validation.constraints.NotNull;

import static com.example.UrlShortener.config.EnvConfig.address;

public class CreateUrlDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        @NotNull
        private String targetUrl;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private String origin;
        private String shorten;

        public static Response fromEntity(Url url) {
            return Response.builder()
                    .origin(url.getOrigin())
                    .shorten(address + url.getShorten())
                    .build();
        }
    }
}

package com.example.UrlShortener.controller;

import com.example.UrlShortener.dto.CreateUrlDto;
import com.example.UrlShortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    public CreateUrlDto.Response createShortenUrl(
        @Valid @RequestBody CreateUrlDto.Request request
    ) {
        log.info("/api/url - {}", request.getTargetUrl());
        return urlService.createShortenUrl(request);
    }
}

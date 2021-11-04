package com.example.UrlShortener.controller;

import com.example.UrlShortener.dto.CreateUrlDto;
import com.example.UrlShortener.dto.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class USController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

package com.example.UrlShortener.controller;

import com.example.UrlShortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class USController {

    private final UrlService urlService;

    @GetMapping("/")
    public String index() {
        log.info("GET /");
        return "index";
    }

    @GetMapping("/{shorten}")
    public String redirect (
            @PathVariable String shorten,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        log.info("GET /{}", shorten);

        String originUrl = urlService.findShortenUrl(shorten);
        if (originUrl != null)
            httpServletResponse.sendRedirect(originUrl);

        log.error("GET /{} - 잘못된 주소로 접근했습니다.", shorten);    
        return "redirect_error";
    }
}

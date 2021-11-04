package com.example.UrlShortener.service;

import com.example.UrlShortener.dto.CreateUrlDto;
import com.example.UrlShortener.entity.Url;
import com.example.UrlShortener.exception.UrlException;
import com.example.UrlShortener.repository.UrlRepository;
import com.example.UrlShortener.util.UrlEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.UrlShortener.exception.ErrorCode.INVALID_URL;
import static com.example.UrlShortener.type.Protocol.HTTP;
import static com.example.UrlShortener.type.Protocol.HTTPS;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final UrlEncoder urlEncoder;

    @Transactional
    public CreateUrlDto.Response createShortenUrl(
            CreateUrlDto.Request request
    ) {
        validateCreateShortenUrl(request.getTargetUrl());

        Url url = urlRepository.findByOrigin(request.getTargetUrl()).orElse(null);

        if (url == null) {
            Url newUrl = Url.builder()
                    .origin(request.getTargetUrl())
                    .build();
            Url savedUrl = urlRepository.save(newUrl);
            savedUrl.setShorten(urlEncoder.encode(savedUrl.getId()));
            urlRepository.save(savedUrl);
            return CreateUrlDto.Response.fromEntity(savedUrl);
        } else {
            return CreateUrlDto.Response.fromEntity(url);
        }
    }

    private void validateCreateShortenUrl(String targetUrl) {
        if (targetUrl.length() < 7)
            throw new UrlException(INVALID_URL);

        if (targetUrl.equals(HTTP.getPrefix()) ||
            targetUrl.equals(HTTPS.getPrefix()))
            throw new UrlException(INVALID_URL);

        if (!targetUrl.startsWith(HTTP.getPrefix()) &&
            !targetUrl.startsWith(HTTPS.getPrefix()))
            throw new UrlException(INVALID_URL);
    }
}

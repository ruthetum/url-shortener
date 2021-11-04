package com.example.UrlShortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {

    public static String address;

    @Value("${environments.address}")
    public void setServerUrl(String address) {
        this.address = address;
    }
}

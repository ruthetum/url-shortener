package com.example.UrlShortener.repository;

import com.example.UrlShortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByOrigin(String origin);
}

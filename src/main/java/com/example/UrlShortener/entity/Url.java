package com.example.UrlShortener.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue
    @Column(name = "url_id")
    private Long id;

    @Column(unique=true)
    private String origin;

    private String shorten;

    private int freq;
}

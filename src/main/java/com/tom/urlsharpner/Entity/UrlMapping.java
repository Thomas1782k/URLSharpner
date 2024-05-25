package com.tom.urlsharpner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "LONGTEXT")
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String shortUrl;

    // Getters and setters
}

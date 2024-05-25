package com.tom.urlsharpner.Service;

import com.tom.urlsharpner.Entity.UrlMapping;
import com.tom.urlsharpner.Exception.ResourceNotFoundException;
import com.tom.urlsharpner.UrlSharpnerRepository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlSharpnerService {

    private final UrlMappingRepository urlMappingRepository;

    public UrlSharpnerService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String shortenUrl(String originalUrl) {
        // Generate a unique key for the URL
        String shortUrl = generateShortUrl();
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        urlMappingRepository.save(urlMapping);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new ResourceNotFoundException("Short URL not found"));
        return urlMapping.getOriginalUrl();
    }

    private String generateShortUrl() {
        // Implement a method to generate a unique short URL
        String shortUrl="short-link-";
        return shortUrl+UUID.randomUUID().toString().substring(0, 6);
    }
}

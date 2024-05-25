package com.tom.urlsharpner.controller;

import com.tom.urlsharpner.Service.UrlSharpnerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlSharpnerController {

    private final UrlSharpnerService urlSharpnerService;

    public UrlSharpnerController(UrlSharpnerService urlSharpnerService){
        this.urlSharpnerService = urlSharpnerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> request) throws MissingServletRequestParameterException {
        String originalUrl = request.get("originalUrl");
        if (originalUrl == null) {
            throw new MissingServletRequestParameterException("originalUrl", "String");
        }
        String shortUrlKey = urlSharpnerService.shortenUrl(originalUrl);
        String shortUrl = "http://localhost:8080/api/" + shortUrlKey;  // Construct the absolute URL
        return ResponseEntity.ok(Map.of("shortUrl", shortUrl));
    }


    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws  IOException {
        String originalUrl = urlSharpnerService.getOriginalUrl(shortUrl);
        response.sendRedirect(originalUrl);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}

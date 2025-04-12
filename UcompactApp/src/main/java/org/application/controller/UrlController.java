package org.application.controller;

import org.application.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    @Autowired
    private ShortUrlService urlService;

    @GetMapping("/shortenUrl")
    public String shortenUrl(@RequestBody String url) {
        return urlService.getShortUrl(url);
    }
}

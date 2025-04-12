package org.application.service;

import org.application.model.ShortUrl;
import org.application.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ShortUrlService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    public String getShortUrl(String url) {
        Optional<ShortUrl> shrtUrl = shortUrlRepository.findByOriginUrl(url);
        if (shrtUrl.isPresent()) {
            return shrtUrl.get().getShortenUrl();
        }
        String newShortUrl = generateShortUrl();
        while(shortUrlRepository.existsByShortenUrl(newShortUrl)) {
            newShortUrl = generateShortUrl();
        }
        ShortUrl shortUrl = ShortUrl.builder().originUrl(url)
                .shortenUrl(newShortUrl).build();
        shortUrlRepository.save(shortUrl);
        return newShortUrl;
    }

    private String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}

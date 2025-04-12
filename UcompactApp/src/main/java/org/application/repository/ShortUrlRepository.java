package org.application.repository;

import org.application.model.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByShortenUrl(String shortenUrl);
    Optional<ShortUrl> findByOriginUrl(String shortUrl);

    boolean existsByShortenUrl(String shortenUrl);
}

package org.application.controller;

import org.application.dto.LinkDto;
import org.application.model.ShortUrl;
import org.application.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    @Autowired
    private ShortUrlService urlService;

    @GetMapping("/shortenUrl")
    public String shortenUrl(@RequestBody LinkDto url) {
        return urlService.getShortUrl(url.getLink());
    }

    @GetMapping("/{url}")
    public RedirectView getShortUrl(@PathVariable String url) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://github.com/");
        return redirectView;
    }
}

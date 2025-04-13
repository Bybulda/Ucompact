package org.application.controller;

import org.application.dto.LinkDto;
import org.application.model.ShortUrl;
import org.application.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/api/url")
public class UrlController {
    @Autowired
    private ShortUrlService urlService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("linkDto", new LinkDto());
        return "url-form";
    }

    @PostMapping("/shorten")
    public String processForm(@ModelAttribute LinkDto linkDto, Model model) {
        String shortUrl = urlService.getShortUrl(linkDto.getLink());
        model.addAttribute("originalUrl", linkDto.getLink());
        model.addAttribute("shortenedUrl", "http://localhost:8080/api/url/" + shortUrl);
        return "result";
    }

    @GetMapping("/{url}")
    public RedirectView redirect(@PathVariable String url) {
        RedirectView redirectView = new RedirectView();
        Optional<ShortUrl> shortUrl = urlService.getOriginalUrl(url);
        if (shortUrl.isPresent()) {
            redirectView.setUrl(shortUrl.get().getOriginUrl());
        }
        return redirectView;
    }
}

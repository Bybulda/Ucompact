package org.application.controller;

import org.application.exceptions.ShortUrlNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleAllExceptions(Exception ex, Model model) {
        model.addAttribute("errorCode", 500);
        model.addAttribute("errorMessage", "Произошла ошибка");
        model.addAttribute("details", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(ShortUrlNotFoundException.class)
    public String handleShortUrlNotFound(ShortUrlNotFoundException ex, Model model) {
        model.addAttribute("errorCode", 404);
        model.addAttribute("errorMessage", "Ссылка не найдена");
        model.addAttribute("details", ex.getMessage());
        return "error";
    }
}
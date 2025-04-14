package org.application.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Configuration
public class ErrorConfig implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request,
                                         HttpStatus status,
                                         Map<String, Object> model) {
        if (status == HttpStatus.NOT_FOUND) {
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("errorCode", 404);
            mav.addObject("errorMessage", "Страница не найдена");
            mav.addObject("details", "Запрошенный URL не существует");
            return mav;
        }
        return null;
    }
}
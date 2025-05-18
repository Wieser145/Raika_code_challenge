package com.example.notizen_app.controllers;

import com.example.notizen_app.services.NotizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotizController {

    @Autowired
    private NotizService notizService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notizen", notizService.getAll());
        return modelAndView;
    }
}

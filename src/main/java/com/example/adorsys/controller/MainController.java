package com.example.adorsys.controller;

import com.example.adorsys.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String mainScreen(@RequestParam(name = "name", required = false, defaultValue = "Boris") String name, Model model) {
        return messageService.mainScreen(name, model);
    }

}

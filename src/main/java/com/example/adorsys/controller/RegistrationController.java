package com.example.adorsys.controller;

import com.example.adorsys.dto.UserDto;
import com.example.adorsys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserDto userDto, Map<String, Object> model) {
        return userService.addUser(userDto, model);
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        return userService.activateUser(code, model);
    }
}

package com.learning.finance.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/financeTracker")
public class MainController {
    @GetMapping(value = "/health")
    public String healthCheck() {
        return "I am OK :)";
    }
}

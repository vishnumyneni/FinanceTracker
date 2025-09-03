package com.learning.design.patterns;

import com.learning.design.patterns.factoryPattern.AccountFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/design-patterns")
public class DesignPatternsExampleController {
    @GetMapping("/factory-pattern")
    public String factoryPatternExample(@RequestParam String type) {
        // Factory Pattern Example
        return AccountFactory.createAccount(type).accountType();
    }
}

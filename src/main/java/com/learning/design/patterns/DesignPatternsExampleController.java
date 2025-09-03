package com.learning.design.patterns;

import com.learning.design.patterns.creational.factoryPattern.AccountFactory;
import com.learning.design.patterns.creational.singletonPattern.TransactionManager;
import com.learning.design.patterns.creational.singletonPattern.TransactionManagerEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/design-patterns")
public class DesignPatternsExampleController {
    @GetMapping("/creational/singleton-pattern")
    public String singletonPatternExample(@RequestParam double amount) {

        Thread thread1 = new Thread(() -> {
            TransactionManager transactionManager = TransactionManager.getInstance();
            System.out.println("Thread 1: " + transactionManager.transfer(amount));
        });
        Thread thread2 = new Thread(() -> {
            TransactionManager transactionManager = TransactionManager.getInstance();
            System.out.println("Thread 2: " + transactionManager.transfer(amount));
        });
        thread1.start();
        thread2.start();
        return "Check my console for singleton pattern output. You will see only one Creating Instance log.";
    }

    @GetMapping("/creational/singleton-pattern/enum")
    public String singletonPatternEnumExample(@RequestParam double amount) {
        Thread thread1 = new Thread(() -> {
            TransactionManagerEnum.INSTANCE.transfer(amount);
        });
        Thread thread2 = new Thread(() -> {
            TransactionManagerEnum.INSTANCE.transfer(amount);
        });
        thread1.start();
        thread2.start();
        return "This is the best way to create Singleton classes using Singleton pattern. Check my console output. You will see only one Creating Instance log.";
    }

    @GetMapping("/creational/factory-pattern")
    public String factoryPatternExample(@RequestParam String type) {
        // Factory Pattern Example
        return AccountFactory.createAccount(type).accountType();
    }
}

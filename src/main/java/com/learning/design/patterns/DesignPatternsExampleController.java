package com.learning.design.patterns;

import com.learning.design.patterns.creational.abstractFactoryPattern.AbstractFactoryProducer;
import com.learning.design.patterns.creational.abstractFactoryPattern.Account;
import com.learning.design.patterns.creational.abstractFactoryPattern.BankingFactory;
import com.learning.design.patterns.creational.abstractFactoryPattern.Loan;
import com.learning.design.patterns.creational.builderPattern.Transaction;
import com.learning.design.patterns.creational.builderPattern.TransactionUsingAnnotations;
import com.learning.design.patterns.creational.factoryPattern.AccountFactory;
import com.learning.design.patterns.creational.factoryPattern.BankAccount;
import com.learning.design.patterns.creational.singletonPattern.TransactionManager;
import com.learning.design.patterns.creational.singletonPattern.TransactionManagerEnum;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Factory Pattern Example", description = "Inputs - loan/savings")
    public String factoryPatternExample(@RequestParam String type) {
        // Factory Pattern Example
        return AccountFactory.createAccount(type).accountType();
    }

    @GetMapping("/creational/abstract-factory-pattern")
    @Operation(summary = "Factory Pattern Example", description = "Inputs - 1. account/loan, 2. savings/checking")
    public String abstractFactoryPatternExample(@RequestParam String type, @RequestParam String accountType) {
        // Abstract Factory Pattern Example
        if ("account".equalsIgnoreCase(type)) {
            BankingFactory bankAccountsFactory = AbstractFactoryProducer.getFactory(type);
            Account bankAccount = bankAccountsFactory.createBankAccount(accountType);
            return bankAccount != null ? bankAccount.accountType() : "Invalid account type. Please use 'savings' or 'checking'.";
        } else if ("loan".equalsIgnoreCase(type)) {
            BankingFactory loanAccountsFactory = AbstractFactoryProducer.getFactory(type);
            Loan loanAccount = loanAccountsFactory.createLoanAccount(accountType);
            return loanAccount != null ? loanAccount.loanType() : "Invalid loan type. Please use 'home' or 'personal'.";
        } else {
            return "Invalid type. Please use 'account' or 'loan'.";
        }
    }

    @GetMapping("/creational/builder-pattern/{fromAccount}/{toAccount}/{amount}")
    public String builderPatternExample(@PathVariable String fromAccount, @PathVariable String toAccount, @PathVariable double amount) {
        Transaction transaction = new Transaction.Builder(fromAccount, toAccount, amount)
                .remarks("Txn created using manually written builder class")
                .build();

        TransactionUsingAnnotations transaction1 = TransactionUsingAnnotations.builder()
                .fromAccount(fromAccount)
                .toAccount(toAccount)
                .amount(amount)
                .remarks("Txn created using Lombok builder annotations")
                .build();

        return "Transaction details: " + transaction.toString() + "\n" +
                "TransactionUsingAnnotations details: " + transaction1.toString();
    }
}

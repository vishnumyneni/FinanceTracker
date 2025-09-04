package com.learning.design.patterns.creational.abstractFactoryPattern;

public class AbstractFactoryProducer {
    public static BankingFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("account")) {
            return new BankAccountsFactory();
        } else if (choice.equalsIgnoreCase("loan")) {
            return new LoanAccountsFactory();
        }
        return null;
    }
}

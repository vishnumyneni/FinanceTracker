package com.learning.design.patterns.factoryPattern;

public class AccountFactory {
    public static BankAccount createAccount(String type) {
        if (type.equalsIgnoreCase("savings")) {
            return new SavingsAccount();
        } else if (type.equalsIgnoreCase("loan")) {
            return new LoanAccount();
        }
        throw new IllegalArgumentException("Unknown account type");
    }
}

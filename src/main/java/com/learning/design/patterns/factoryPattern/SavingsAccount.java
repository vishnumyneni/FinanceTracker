package com.learning.design.patterns.factoryPattern;

public class SavingsAccount implements BankAccount {
    @Override
    public String accountType() {
        return "Savings Account";
    }
}

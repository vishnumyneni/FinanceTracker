package com.learning.design.patterns.creational.factoryPattern;

public class SavingsAccount implements BankAccount {
    @Override
    public String accountType() {
        return "Savings Account";
    }
}

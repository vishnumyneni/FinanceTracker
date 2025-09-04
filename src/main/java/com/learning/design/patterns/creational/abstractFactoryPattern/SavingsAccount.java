package com.learning.design.patterns.creational.abstractFactoryPattern;

public class SavingsAccount implements Account {
    @Override
    public String accountType() {
        return "Savings Account";
    }
}

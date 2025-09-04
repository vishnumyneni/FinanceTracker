package com.learning.design.patterns.creational.abstractFactoryPattern;

public class CheckingAccount implements Account {
    @Override
    public String accountType() {
        return "Current Account";
    }
}

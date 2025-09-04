package com.learning.design.patterns.creational.singletonPattern;

public enum TransactionManagerEnum {
    INSTANCE;

    TransactionManagerEnum() {
        System.out.println("Creating instance");
    }
    
    public String transfer(double amount) {
        return "Transaction successful" + amount;
    }
}

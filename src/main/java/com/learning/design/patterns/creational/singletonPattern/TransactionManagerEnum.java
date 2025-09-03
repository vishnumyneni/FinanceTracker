package com.learning.design.patterns.creational.singletonPattern;

public enum TransactionManagerEnum {
    INSTANCE;

    public String transfer(double amount) {
        return "Transaction successful" + amount;
    }
}

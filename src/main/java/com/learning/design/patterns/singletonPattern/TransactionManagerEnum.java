package com.learning.design.patterns.singletonPattern;

public enum TransactionManagerEnum {
    INSTANCE;

    public String transfer(double amount) {
        return "Transaction successful" + amount;
    }
}

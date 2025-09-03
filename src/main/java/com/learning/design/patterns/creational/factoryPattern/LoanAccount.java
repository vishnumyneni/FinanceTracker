package com.learning.design.patterns.creational.factoryPattern;

public class LoanAccount implements BankAccount {
    @Override
    public String accountType() {
        return "Loan Account";
    }
}
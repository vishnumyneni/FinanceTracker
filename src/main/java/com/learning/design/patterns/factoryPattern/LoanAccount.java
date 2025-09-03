package com.learning.design.patterns.factoryPattern;

public class LoanAccount implements BankAccount {
    @Override
    public String accountType() {
        return "Loan Account";
    }
}
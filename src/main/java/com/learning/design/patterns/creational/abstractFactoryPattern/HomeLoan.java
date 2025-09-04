package com.learning.design.patterns.creational.abstractFactoryPattern;

public class HomeLoan implements Loan {
    @Override
    public String loanType() {
        return "Home Loan";
    }
}

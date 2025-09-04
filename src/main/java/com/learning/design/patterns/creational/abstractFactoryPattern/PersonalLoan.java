package com.learning.design.patterns.creational.abstractFactoryPattern;

public class PersonalLoan implements Loan {
    @Override
    public String loanType() {
        return "Personal Loan";
    }
}

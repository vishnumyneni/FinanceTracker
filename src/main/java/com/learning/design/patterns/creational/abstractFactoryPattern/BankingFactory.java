package com.learning.design.patterns.creational.abstractFactoryPattern;

public interface BankingFactory {


    Account createBankAccount(String accountType);
    Loan createLoanAccount(String loanType);
}

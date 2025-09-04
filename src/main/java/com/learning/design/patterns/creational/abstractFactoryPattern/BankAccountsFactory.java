package com.learning.design.patterns.creational.abstractFactoryPattern;

class BankAccountsFactory implements BankingFactory{
    @Override
    public Account createBankAccount(String accountType) {
        if("savings".equalsIgnoreCase(accountType)){
            return new SavingsAccount();
        } else if("checking".equalsIgnoreCase(accountType)){
            return new CheckingAccount();
        }
        return null;
    }

    @Override
    public Loan createLoanAccount(String loanType) {
        return null; // This factory does not create Loan accounts
    }
}

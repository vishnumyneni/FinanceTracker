package com.learning.design.patterns.creational.abstractFactoryPattern;

class LoanAccountsFactory implements BankingFactory{
    @Override
    public Account createBankAccount(String accountType) {
        return null;
    }

    @Override
    public Loan createLoanAccount(String loanType) {
        if("home".equalsIgnoreCase(loanType)){
            return new HomeLoan();
        } else if("personal".equalsIgnoreCase(loanType)){
            return new PersonalLoan();
        }
        return null;
    }
}

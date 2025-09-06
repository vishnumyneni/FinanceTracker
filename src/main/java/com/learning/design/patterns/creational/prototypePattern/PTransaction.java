package com.learning.design.patterns.creational.prototypePattern;

import lombok.Setter;

@Setter
public class PTransaction implements ProtoType {
    private String fromAccount;
    private String toAccount;
    private double amount;

    public PTransaction(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    private PTransaction(PTransaction PTransaction) {
        this.fromAccount = PTransaction.fromAccount;
        this.toAccount = PTransaction.toAccount;
        this.amount = PTransaction.amount;
    }

    @Override
    public PTransaction getClone() {
        return new PTransaction(this);
    }

    @Override
    public String toString() {
        return "fromAccount: '" + fromAccount + '\'' +
                ", toAccount: '" + toAccount + '\'' +
                ", amount= " + amount;
    }
}

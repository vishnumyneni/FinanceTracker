package com.learning.design.patterns.creational.builderPattern;

public class Transaction {
    // Mandatory fields
    private String fromAccount;
    private String toAccount;
    private double amount;

    // Optional fields
    private String remarks;

    public Transaction(Builder builder) {
        this.fromAccount = builder.fromAccount;
        this.toAccount = builder.toAccount;
        this.amount = builder.amount;
        this.remarks = builder.remarks;
    }

    public static class Builder {
        // Mandatory fields
        private String fromAccount;
        private String toAccount;
        private double amount;

        // Optional fields
        private String remarks;

        public Builder(String fromAccount, String toAccount, double amount) {
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
            this.amount = amount;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    public String toString() {
        return "Transaction{" +
                "fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

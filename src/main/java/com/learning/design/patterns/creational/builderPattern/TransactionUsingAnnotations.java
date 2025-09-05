package com.learning.design.patterns.creational.builderPattern;

import lombok.Builder;

@Builder
public class TransactionUsingAnnotations {
    // Mandatory fields
    private String fromAccount;
    private String toAccount;
    private double amount;

    // Optional fields
    private String remarks;

    @Override
    public String toString() {
        return "TransactionUsingAnnotations{" +
                "fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

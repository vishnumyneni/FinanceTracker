package com.learning.design.patterns.creational.singletonPattern;

public class TransactionManager {
    static TransactionManager transactionManager;
    private TransactionManager(){
        System.out.println("Creating instance");}

    public static TransactionManager getInstance() {
        if (transactionManager == null) {
            synchronized(TransactionManager.class){
                    if (transactionManager == null) {
                        transactionManager = new TransactionManager();
                    }
            }
        }
        return transactionManager;
    }
    public String transfer(double amount) {
        return "Transaction successful" + amount;
    }
}

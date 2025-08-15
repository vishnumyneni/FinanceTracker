package com.learning.finance.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {

    private String id;
    private String type;
    private String category;
    private double amount;
    private Date date;
    private String notes;
}

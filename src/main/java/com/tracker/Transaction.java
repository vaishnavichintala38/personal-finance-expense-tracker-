package com.tracker;

public class Transaction {
    private String title;
    private double amount;
    private String type;

    public Transaction(String title, double amount, String type) {
        this.title = title;
        this.amount = amount;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}

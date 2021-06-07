package com.bank.atm.model;

public abstract class Model {
    protected int id;
    protected String name;
    protected String nationalId;
    protected double balance;
    protected double creditBalance;

    // **************** Id Setter and Getter ****************//
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // **************** Name Setter and Getter ****************//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // **************** NationalId Setter and Getter ****************//
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalId() {
        return nationalId;
    }

    // **************** Balance Setter and Getter ****************//
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // **************** CreditBalance Setter and Getter ****************//
    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

}

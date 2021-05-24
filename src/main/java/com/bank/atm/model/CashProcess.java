package com.bank.atm.model;

import java.util.Date;

public class CashProcess {
    private int id;
    private String name;
    private String nationalId;
    private double amount;
    private String process;
    private double balance;
    private Date date;
    private String description;
    private String payTo;

    // **************** Constructor ****************//
    public CashProcess() {
    }

    // **************** Custom Constructor ****************//
    public CashProcess(int id, String name, String nationalId, double amount, String process, double balance, Date date,
            String description, String payTo) {
        this.id = id;
        this.name = name;
        this.nationalId = nationalId;
        this.amount = amount;
        this.process = process;
        this.balance = balance;
        this.balance = balance;
        this.date = date;
        this.description = description;
        this.payTo = payTo;

    }

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

    // **************** Amount Setter and Getter ****************//
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    // **************** Process Setter and Getter ****************//
    public void setProcess(String process) {
        this.process = process;
    }

    public String getProcess() {
        return process;
    }// **************** Balance Setter and Getter ****************//

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // **************** Date Setter and Getter ****************//
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    // **************** Description Setter and Getter ****************//
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // **************** to Setter and Getter ****************//
    public void setPayTo(String payTo) {
        this.payTo = payTo;
    }

    public String getPayTo() {
        return payTo;
    }

    @Override
    public String toString() {
        return "CashProcess{" + "id=" + id + ", name='" + name + ", nationalId=" + nationalId + ", date=" + date
                + ", balance=" + balance + ", amount=" + amount + ", process=" + process + ", description="
                + description + ", payTo=" + payTo + '}';
    }

}

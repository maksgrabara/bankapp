package com.maxtheraven.bankapp.code.model;

public class Account {

    private String userID;
    private String accountID;
    private String accountName;
    private String accountType;
    private String accountBalance;
    private String currency;

    public Account(String userID,
                   String accountID,
                   String accountName,
                   String accountType,
                   String accountBalance,
                   String currency) {

        this.userID = userID;
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

    public String getUserID() {
        return userID;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
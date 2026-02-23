package com.maxtheraven.bankapp.code.model;

public class Transaction {

    private String sendingUserID;
    private String sendingAccountID;
    private String receivingAccountID;
    private String amountSent;
    private String amountReceived;
    private String currencySent;
    private String currencyReceived;
    private String transactionDate;

    public Transaction(String sendingUserID,
                       String sendingAccountID,
                       String receivingAccountID,
                       String amountSent,
                       String amountReceived,
                       String currencySent,
                       String currencyReceived,
                       String transactionDate) {

        this.sendingUserID = sendingUserID;
        this.sendingAccountID = sendingAccountID;
        this.receivingAccountID = receivingAccountID;
        this.amountSent = amountSent;
        this.amountReceived = amountReceived;
        this.currencySent = currencySent;
        this.currencyReceived = currencyReceived;
        this.transactionDate = transactionDate;
    }

    public String getSendingUserID() {
        return sendingUserID;
    }

    public String getSendingAccountID() {
        return sendingAccountID;
    }

    public String getReceivingAccountID() {
        return receivingAccountID;
    }

    public String getAmountSent() {
        return amountSent;
    }

    public String getAmountReceived() {
        return amountReceived;
    }

    public String getCurrencySent() {
        return currencySent;
    }

    public String getCurrencyReceived() {
        return currencyReceived;
    }

    public String getTransactionDate() {
        return transactionDate;
    }
}
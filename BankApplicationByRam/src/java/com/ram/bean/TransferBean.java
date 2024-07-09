/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ram.bean;

/**
 *
 * @author Admin
 */
public class TransferBean {
private int  transactionID;
private String accountNumber;
private String beneficiaryAccountnumber;
private String transactionDate ;
private String transactionAmount;

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBeneficiaryAccountnumber() {
        return beneficiaryAccountnumber;
    }

    public void setBeneficiaryAccountnumber(String beneficiaryAccountnumber) {
        this.beneficiaryAccountnumber = beneficiaryAccountnumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public TransferBean() {
    }

    public TransferBean(int transactionID, String accountNumber, String beneficiaryAccountnumber, String transactionDate, String transactionAmount) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.beneficiaryAccountnumber = beneficiaryAccountnumber;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    
}

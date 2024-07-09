/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ram.dao;

import com.ram.bean.TransferBean;
import com.ram.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BankDAO {

    static Connection conn = null;

    private boolean validateAccount(String accountNumber) {
        boolean b = false;
        String sql = "select accountNumber from account_tbl where accountNumber='" + accountNumber + "'";
        conn = ConnectionPool.connectDB();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                b = true;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public double findBalance(String accountNumber) {
        double res = 0;
        String sql = "select balance from account_tbl where accountNumber='" + accountNumber + "'";
        conn = ConnectionPool.connectDB();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                res = rs.getDouble("balance");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public boolean updateBalance(String accountNumber, double newBalance) {
        boolean b = false;
        conn = ConnectionPool.connectDB();
        String sql = "update account_tbl set balance='" + newBalance + "' where accountNumber='" + accountNumber + "'";
        try {
            Statement stmt = conn.createStatement();
            int r = stmt.executeUpdate(sql);
            if (r > 0) {
                b = true;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public boolean transfertMoney(TransferBean tb) {
        conn = ConnectionPool.connectDB();
        boolean r = false;
        BankDAO bd = new BankDAO();
        if ((bd.validateAccount(tb.getAccountNumber()) && bd.validateAccount(tb.getBeneficiaryAccountnumber()))) {

            double fromAmount = bd.findBalance(tb.getAccountNumber());
            System.out.println("From Account Balance : " + fromAmount);
            double tamount = Double.parseDouble(tb.getTransactionAmount());
            System.out.println("Transfer Amount  : " + tamount);
            if(fromAmount>tamount){
                bd.updateBalance(tb.getAccountNumber(), fromAmount-tamount);
                bd.updateBalance(tb.getBeneficiaryAccountnumber(), bd.findBalance(tb.getBeneficiaryAccountnumber())+tamount);
                  int tid = (int) (Math.random() * 100000);
                  String sql="insert into transfer_tbl values('"+tid+"','"+tb.getAccountNumber()+"','"+tb.getBeneficiaryAccountnumber()+"','"+tb.getTransactionDate()+"','"+tb.getTransactionAmount()+"')";
                  Connection conn=ConnectionPool.connectDB();
                try {
                    Statement stmt=conn.createStatement();
                      int x=stmt.executeUpdate(sql);
                      if(x>0){
                          r=true;
                      }
                } catch (SQLException ex) {
                    Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                  
            }
        }
     

        return r;
    }

    public static void main(String[] args) {
        BankDAO vd = new BankDAO();
//        boolean x = vd.validateAccount("1234567892");
//        if (x) {
//            System.out.println("This is Valid Account");
//        } else {
//            System.out.println("This is Invalid Account");
//        }
//        
//System.out.println("Your Balance is : "+vd.findBalance("1234567891"));
//boolean b=vd.updateBalance("1234567890", 910000);
//        System.out.println("Account Balance Updated "+b);
        TransferBean tb = new TransferBean();
        tb.setAccountNumber("1234567890");
        tb.setBeneficiaryAccountnumber("1234567891");
        tb.setTransactionAmount("10000");
        tb.setTransactionDate("30-MAY-2024");

        boolean b = vd.transfertMoney(tb);
        System.out.println("Amount Transfer Success : "+b);
        
    }
}

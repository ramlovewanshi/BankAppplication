/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ram.dao;

import com.ram.bean.AccountBean;
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
public class AccountDAO {
    static Connection conn;
    public boolean createNewAccount(AccountBean ac){
        conn=ConnectionPool.connectDB();
        boolean b=false;
        int r=0;
        String sql="insert into account_tbl values('"+ac.getAccountNumber()+"','"+ac.getCustomerName()+"','"+ac.getBalance()+"')";
        try {
            Statement stmt=conn.createStatement();
            r=stmt.executeUpdate(sql);
            if(r>0){
                b=true;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    public AccountBean loginCheck(String userName,String password){
        conn=ConnectionPool.connectDB();
        AccountBean ab=new AccountBean();
        String sql="select * from account_tbl where un='"+userName+"' and ps='"+password+"'";
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                ab.setAccountNumber(rs.getString("accountNumber"));
                ab.setCustomerName(rs.getString("customerName"));
                ab.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ab;
    }
    public static void main(String[] args) {
       AccountDAO ad=new AccountDAO();
       AccountBean ab=ad.loginCheck("Reddy123", "1111");
        System.out.println("Account Number : "+ab.getAccountNumber());
        System.out.println("Name : "+ab.getCustomerName());
        System.out.println("Balance: "+ab.getBalance());
        
        
    }
}

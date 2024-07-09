/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ram.utility;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {
   static Connection  conn;
   //Member data static
   public static Connection connectDB(){
       try {
           //step1: Register The Driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //step2: Create The Connection
           String url="jdbc:mysql://localhost:3306/bank";
           String un="root";
           String ps="Ram@1234";
           conn=DriverManager.getConnection(url, un, ps);
           System.out.println("Database connectivity success");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
   }
    public static void main(String[] args) {
        connectDB();
    }
}

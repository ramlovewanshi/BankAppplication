<%-- 
    Document   : transfer
    Created on : 5 Jun, 2024, 7:29:13 PM
    Author     : Admin
--%>

<%@page import="com.ram.bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
  AccountBean ac=(AccountBean)session.getAttribute("user");
        
        %>
        <hr color='green'>
        <h1 align='right'>Welcome : <%=ac.getCustomerName() %></h1>
        <hr color='red'>
        
       <form action="TransferController" method="post">
            <table>
                <tr>
                    <td>Account Number : </td>
                    <td><input type="text"  readonly="true" name="acno" value=<%=ac.getAccountNumber() %>></td>
                </tr>
                    <tr>
                    <td>To Account Number : </td>
                    <td><input type="text" name="toacno"></td>
                </tr>
                     <tr>
                    <td>Transaction Date : </td>
                    <td><input type="date" name="tdate"></td>
                </tr>
                
                    <tr>
                    <td>Transaction Amount: </td>
                    <td><input type="text" name="tamt"></td>
                </tr>
                <tr>
                    <td>&nbsp; </td>
                    <td><input type="submit" value="Transfer Amount"></td>
                </tr>
                
            </table>
        </form>
        
    </body>
</html>

<%-- 
    Document   : new_account
    Created on : 5 Jun, 2024, 6:49:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AccountController" method="post">
            <table>
                <tr>
                    <td>Account Number : </td>
                    <td><input type="text" name="acno"></td>
                </tr>
                    <tr>
                    <td>Customer Name : </td>
                    <td><input type="text" name="cn"></td>
                </tr>
                
                    <tr>
                    <td>Balance: </td>
                    <td><input type="text" name="bal"></td>
                </tr>
                <tr>
                    <td>&nbsp; </td>
                    <td><input type="submit" value="Create New Account"></td>
                </tr>
                
            </table>
        </form>
    </body>
</html>

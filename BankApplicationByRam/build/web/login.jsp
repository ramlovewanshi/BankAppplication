<%-- 
    Document   : login
    Created on : 5 Jun, 2024, 7:32:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <form action="LoginController" method="post">
            <table>
                <tr>
                    <td>UserName : </td>
                    <td><input type="text" name="un"></td>
                </tr>
                    <tr>
                    <td>Password : </td>
                    <td><input type="text" name="ps"></td>
                </tr>
                
                   
                    <td>&nbsp; </td>
                    <td><input type="submit" value="Login Here"></td>
                </tr>
                
            </table>
        </form>
</html>

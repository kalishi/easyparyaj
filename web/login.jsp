<%-- 
    Document   : login
    Created on : May 17, 2023, 9:04:42 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="login-form" action="login" method="POST">
            <label for="username">Username</label>
            <input type="text" id="username" name="username">
            <label for="password">password</label>
            <input type="password" id="password" name="password" maxlength="200">
            <input type="submit" value="Connect">
        </form>
    </body>
</html>

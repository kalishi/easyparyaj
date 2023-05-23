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
        <link rel="stylesheet" href="static/login.css" />
    </head>
    <body>
        
        <form name="login-form" action="login" method="POST">
            <h1 class="login_title">Login to your Account</h1>
            <h1 class="subtitle">Enter your Details</h1>
<!--            <label for="username">Username</label>-->
            <input type="text" id="username" name="username" placeholder="Your User Name">
<!--            <label for="password">Password</label>-->
            <input type="password" id="password" name="password" maxlength="200" placeholder="Your Password">
            <input type="submit" value="Connect">
            <%
                if (request.getAttribute("loginError") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("loginError")%></p>

            <%
                }

                if (request.getAttribute("msg") != null) {
            %>
            <p class="error" style="color: red"><%= request.getAttribute("msg")%></p>

            <%
                }
            %>
        </form>
    </body>
</html>

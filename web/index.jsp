<%-- 
    Document   : index
    Created on : May 13, 2023, 10:24:34 PM
    Author     : DTelcy
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyParyaj | Home</title>
        <link rel="stylesheet" href="static/index.css"/>
        <link href="https://api.fontshare.com/v2/css?f[]=satoshi@900,700,500,301,701,300,501,401,901,400&display=swap" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>

        <%
                if (request.getAttribute("error") != null) {
        %>
        <p class="error" style="color: red"><%= request.getAttribute("error")%></p>

        <%
            }
        %> 

        
    <div class="carousel">
        <div class="slides">
            <div class="slide">
                <img src="static/img1.jpg" alt="Image 1">
            </div>
            <div class="slide">
                <img src="static/img2.jpg" alt="Image 2">
            </div>
            <div class="slide">
                <img src="static/img3.jpg" alt="Image 3">
            </div>
        </div>
    </div>
    <script src="static/carousel.js"></script>
</body>
</html>

<%@page import="Model.User"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/index.css"/>
<link href="https://api.fontshare.com/v2/css?f[]=satoshi@900,700,500,301,701,300,501,401,901,400&display=swap" rel="stylesheet">
<header>
    <h1 id="logo"> EasyParyaj</h1>  
    <nav>
        <ul>
            <%
                if (session.getAttribute("user") != null && (Boolean) session.getAttribute("authenticated")) {
                    User user = (User) session.getAttribute("user");
                    if (user.isAdmin()) {
            %>
            <li><a href="<%=request.getContextPath()%>/admin" class="btn btn1">admin</a></li>
            <%}%>
            <li><small><%=user.getSolde()%></small></li>
            <li><a href="<%=request.getContextPath()%>/accounts/profile">Profile</a></li>
            <li><a href="<%=request.getContextPath()%>/accounts/pariage">New pariage</a>  </li>
            <li><a href="<%=request.getContextPath()%>/logout">logout</a></li>
                
            <%}else{%>
            <li><a href="<%=request.getContextPath()%>/login" class="btn btn1">Log in</a> </li>
            <li><a href="<%=request.getContextPath()%>/signup" class="btn2">Sign up</a> </li>
                <%}%>
        </ul>
    </nav>
</header>
<%@page import="Model.User"%>
<link rel="stylesheet" href="static/index.css"/>
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

            <li><a href="admin" class="btn btn1">admin</a></li>
            <li> <a href="logout" class="btn2">logout</a></li>
                <%
                } else {
                %>

            <li><a href="accounts/profile">Profile</a></li>
            <li><a href="accounts/pariage">New pariage</a>  </li>
            <li><a href="logout">logout</a></li>
                <%
                    }
                } else {

                %> 

            <li><a href="login" class="btn btn1">Log in</a> </li>
            <li><a href="signup" class="btn2">Sign up</a> </li>
                <%                        }
                %>
        </ul>
    </nav>
</header>
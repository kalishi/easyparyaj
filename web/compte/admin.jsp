<%-- 
    Document   : admin
    Created on : May 21, 2023, 8:10:29 PM
    Author     : DTelcy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/main.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <script src="../static/jquery-3.6.4.min.js"></script>
        <script>
            $(function () {
                $("#user").load("../admin/users");
                $("#rencontre").load("admin/match");
                $("#parriage").load("/admin/pariages");
            });
        </script>
    </head>
    <body>
        <script src="../static/jquery-3.6.4.min.js"></script>
        <div class="container">
            <nav class="sidebar">
                <div class="menu-bar">
                    <!--<h2>Welcome <%=session.getAttribute("user")%></h2>-->
                    <div class="menu">
                        <ul class="menu-links tabs">
                            <li class="nav-link tab is-active" >
                                <a data-switcher data-tab="1" class="link">
                                    <img src="static/u_mgmt.png" alt="user-management"/>
                                    <h3>User managment</h3>
                                </a>
                            </li>
                            <li class="nav-link tab">
                                <a data-switcher data-tab="2" class="link">
                                    <img src="static/m_mgmt.png" alt="user-management"/>
                                    <h3>Rencontre managment</h3>
                                </a>
                            </li>
                            <li class="nav-link tab">
                                <a data-switcher data-tab="3" class="link">
                                    <img src="static/r_mgmt.png" alt="user-management"/>
                                    <h3>Parriage managment</h3>
                                </a>
                            </li>
                            <li class="log-out">
                                <a href="<%=request.getContextPath()%>/logout">
                                    <h2>Log out</h2>
                                </a>
                            </li>
                        </ul>
                    </div> 
                </div>

            </nav>

        </div>

        <section class="pages">
            <div class="page is-active" data-page="1">
                <div id="user"></div>
            </div>
            <div class="page" data-page="2">
                <div id="rencontre"></div>
            </div>
            <div class="page" data-page="3">
                <div id="parriage"></div>
            </div>
        </section>

        <script src="../static/sidebar.js"></script>

        <script>
            $(document).ready(function () {
                // When a tab is clicked
                $(".tab").on("click", function () {
                    // Get the data-tab attribute value of the clicked tab
                    var tab = $(this).find("a").data("tab");
                    // Show the corresponding page
                    $(".page").removeClass("is-active");
                    $('.page[data-page="' + tab + '"]').addClass("is-active");
                    // Set the selected tab in sessionStorage
                    sessionStorage.setItem("selectedTab", tab);
                });

                // When the page loads
                var selectedTab = sessionStorage.getItem("selectedTab");
                // If a selected tab exists, show its corresponding page
                if (selectedTab) {
                    $(".page").removeClass("is-active");
                    $('.page[data-page="' + selectedTab + '"]').addClass("is-active");
                }
            });
        </script>

        <!-- Script to stay in active page start here  -->
        <script>
            // Get the active tab index from localStorage
            let activeTabIndex = localStorage.getItem("activeTabIndex");

            // If the active tab index is null or undefined, set it to 0 (the first tab)
            if (activeTabIndex === null || activeTabIndex === undefined) {
                activeTabIndex = 0;
            }

            // Set the active class on the active tab and show the corresponding page
            const tabs = document.querySelectorAll(".menu-links .tab");
            tabs[activeTabIndex].classList.add("is-active");
            const pages = document.querySelectorAll(".pages .page");
            pages[activeTabIndex].classList.add("is-active");

            // Add a click event listener to each tab to store the active tab index in localStorage
            tabs.forEach((tab, index) => {
                tab.addEventListener("click", () => {
                    // Remove the active class from all tabs and pages
                    tabs.forEach((tab) => tab.classList.remove("is-active"));
                    pages.forEach((page) => page.classList.remove("is-active"));

                    // Add the active class to the clicked tab and show the corresponding page
                    tab.classList.add("is-active");
                    pages[index].classList.add("is-active");

                    // Store the active tab index in localStorage
                    localStorage.setItem("activeTabIndex", index);
                });
            });
        </script>

        <!--        <div id="admin-links">
                    <a href="admin/users">
                        <div class = "div-link">
                            <img src="static/u_mgmt.png" alt="user-management"/>
                            <h3>User managment</h3>
                        </div>
                    </a>   
                    <a href="admin/matches">
                        <div class = "div-link">
                            <img src="static/m_mgmt.png" alt="user-management"/>
                            <h3>Rencontre managment</h3>
                        </div>
                    </a>
                    <a href="admin/pariages">
                        <div class = "div-link">
                            <img src="static/r_mgmt.png" alt="user-management"/>
                            <h3>Parriage managment</h3>
                        </div>
                    </a>
        
        
                </div>-->

    </body>
</html>

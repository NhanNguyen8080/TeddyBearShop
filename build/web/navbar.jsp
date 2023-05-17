<%-- 
    Document   : narbar
    Created on : Mar 19, 2023, 12:24:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .navbar-brand {
            color: brown !important;
            font-weight: 700;
        }
        
        .bg-light {
            width: 100%;
            z-index: 99;
            position: fixed; 
        }
    </style>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="user.jsp">Bear Shop</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="user.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ListProductsInCartController?username=${sessionScope.USERNAME}">Cart</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="DispatchController">
                    <input class="form-control mr-sm-2" type="search" name="search" value="${param.search}" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="Find">Search</button>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="Log out">Log out</button>
                </form>
            </div>
        </nav>
    </body>
</html>

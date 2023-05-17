<%-- 
    Document   : Login
    Created on : Feb 28, 2023, 8:03:30 AM
    Author     : dell
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form action="DispatchController" method="post">
                        <h2>Login</h2>
                        <div class="inputbox">
                            <ion-icon name="mail-outline"></ion-icon>
                            <input type="text" required name="username">
                            <label for="">Username</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="password" required name="password">
                            <label for="">Password</label>
                        </div>
                        <p style="color:red;">${requestScope.INVALID_USER}</p>
                        <div class="forget">
                            <!--<label for=""><input type="checkbox">Remember Me-->  
                            <!--<a href="#" class="forget_password">Forget Password</a></label>-->
                        </div>
                        <input class="submit" style="background-color: none;"type="submit" name="action" value="Log in"/>
                        <div class="register">
                            <p>Don't have a account? <a href="registration.jsp">Register</a></p>
                        </div>
                        <p class="error_message">${requestScope.ERROR_MESSAGE}</p>
                    </form>
                    
                </div>
            </div>
        </section>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>

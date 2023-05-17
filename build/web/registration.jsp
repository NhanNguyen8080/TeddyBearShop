<%-- 
    Document   : register
    Created on : Feb 28, 2023, 8:10:17 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/style.css">

        <style>
            .form-box {
                height: 500px;
            }
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <a class="back_to_login" href="login.jsp"><i class="fa-solid fa-arrow-left"></i></a>
                    <form action="DispatchController" method="post">
                        <h2>Register</h2>
                        <div class="inputbox">
                            <!--<ion-icon name="mail-outline"></ion-icon>-->
                            <input type="text" required name="username">
                            <label for="">Username</label>
                        </div>
                        <div class="inputbox">
                            <!--<ion-icon name="lock-closed-outline"></ion-icon>-->
                            <input type="password" required name="password">
                            <label for="">Password</label>
                        </div>
                        <div class="inputbox">
                            <!--<ion-icon name="lock-closed-outline"></ion-icon>-->
                            <input type="text" required name="email">
                            <label for="">Email</label>
                        </div>
                        <div class="inputbox">
                            <!--<ion-icon name="lock-closed-outline"></ion-icon>-->
                            <input type="text" required name="fullname">
                            <label for="">Fullname</label>
                        </div>
                        <div class="forget">
                            <!--<label for=""><input type="checkbox">Remember Me-->  
                            <!--<a href="#" class="forget_password">Forget Password</a></label>-->
                        </div>
                        <input class="submit" type="submit" name="action" value="Sign up"/>
                        <p class="error_message">${requestScope.DUPLICATE}</p>
                    </form>
                </div>
            </div>
        </section>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://kit.fontawesome.com/561cbb1cce.js" crossorigin="anonymous"></script>

    </body>
</html>

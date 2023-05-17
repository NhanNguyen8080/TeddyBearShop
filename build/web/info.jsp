<%-- 
    Document   : info
    Created on : Mar 23, 2023, 1:04:18 PM
    Author     : ADMIN
--%>
<%@page import="sample.cart.CartDTO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipping detail</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            @import url('https://fonts.googleapis.com/css?family=Arimo');

            body {
                display: flex;
                justify-content: center;
            }

            .wrapper {
                margin-top: 3%;
                width: 60%;
                display: flex;
                justify-content: center;
                font-family: "Arimo";
                background-color: #eb9478;
                -webkit-box-shadow: 9px 13px 25px 0px rgba(0, 0, 0, 0.18);
                -moz-box-shadow: 9px 13px 25px 0px rgba(0, 0, 0, 0.18);
                box-shadow: 9px 13px 25px 0px rgba(0, 0, 0, 0.18);
                animation: slideUp 2000ms ease;
            }

            @keyframes slideUp {
                0% {
                    -webkit-transform: translateY(100%);
                    transform: translateY(100%);
                    visibility: visible;
                }

                100% {
                    -webkit-transform: translateY(0);
                    transform: translateY(0);

                }
            }

            .container {
                width: 65%;
                padding: 5% 10%;
            }

            h1 {
                align-self: center;
            }

            input {
                width: 100%;
                min-height: 25px;
                border: 0;
                font-size: 1rem;
                letter-spacing: .15rem;
                font-family: "Arimo";
                margin-top: 5px;
                color: #8e2807;
                border-radius: 4px;
            }   

            label {
                text-transform: uppercase;
                font-size: 12px;
                letter-spacing: 2px;
                color: #8e2807;
            }

            h1 {
                height: 24px;
                font-size: 24px;
                line-height: 21px;
                color: #493b76;
                letter-spacing: 1px;
            }

            h1:nth-of-type(2) {
                margin-top: 10%;
            }

            .cc-num {
                margin-top: 20px;
            }

            .name {
                margin-top: 20px;
            }

            form {
                width: 100%;
            }

            form * {
                margin-top: 10px;
            }

            .name {
                justify-content: space-between;
                display: flex;
                width: 100%;
            }

            .name div {
                width: 45%;
            }

            .address-info {
                display: flex;
                justify-content: space-between;
            }

            .address-info div {
                width: 30%;
            }

            .cc-info {
                display: flex;
                justify-content: space-between;
            }

            .cc-info div {
                width: 45%;
            }

            .btns {
                display: flex;
                flex-direction: column;
                align-items: flex-end;
                margin-top: 40px;
            }

            .btns button {
                margin: 3px 0;
                height: 30px;
                width: 40%;
                color: #cfc9e1;
                background-color: #4a3b76;
                text-transform: uppercase;
                border: 0;
                border-radius: .3rem;
                letter-spacing: 2px;
            }

            .btns button &:hover {
                animation-name: btn-hov;
                animation-duration: 550ms;
                animation-fill-mode: forwards;
            }

            @keyframes btn-hov {
                100% {
                    background-color: #cfc9e1;
                    color: #4a3b76;
                    transform: scale(1.05)
                }
            }

            input {
                padding: 0 10px;
            }
            input:focus,
            button:focus {
                outline: none;
            }

            @media (max-width: 736px) {
                .wrapper {
                    width: 100%;
                }

                .container {
                    width: 100%;
                }

                .btns {
                    align-items: center;
                }

                .btns button {
                    width: 50%;
                }

                form h1 {
                    text-align: center;
                }

                .name,
                .address-info,
                .cc-info {
                    flex-direction: column;
                    width: 100%;
                    justify-content: space-between;
                }

                .name div,
                .address-info div,
                .cc-info div {
                    align-items: center;
                    flex-direction: column;
                    width: 100%;
                    display: flex;
                }

                .btns button a:focus {
                    color: #fff;
                }

                .street,
                .cc-num {
                    text-align: center;
                }

                input {
                    margin: 5px 0;
                    min-height: 30px;
                }
            }
        </style>
    </head>
    <body>
        <c:set var="list" value="${sessionScope.CART_LIST}"/>
        <c:forEach var="list" items="${list}">
            <c:set var="total" value="${total + list.price * list.quantity} "/>
        </c:forEach>
        <%
            List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("CART_LIST");
            session.setAttribute("CART_LIST", cartList);
        %>
        <div class="wrapper">
            <div class="container">
                <form action="DispatchController" method="post">
                    <h1>
                        Shipping Details
                    </h1>
                    <div class="name">
                        <div>
                            <label for="f-name">First</label>
                            <input type="text" name="f-name">
                        </div>
                        <div>
                            <label for="l-name">Last</label>
                            <input type="text" name="l-name">
                        </div>
                    </div>
                    <div class="street">
                        <label for="name">Street</label>
                        <input type="text" name="address" required>
                    </div>
                    <div class="address-info">
                        <div>
                            <label for="city">City</label>
                            <input type="text" name="city" required>
                        </div>
                        <div>
                            <label for="state">State</label>
                            <input type="text" name="state" required>
                        </div>
                        <div>
                            <label for="zip">Zip</label>
                            <input type="text" name="zip" required >
                        </div>
                    </div>
                    <h1>
                        Payment Information
                    </h1>
                    <div class="cc-num">
                        <label for="card-num">Credit Card No.</label>
                        <input type="text" name="card-num" required>
                    </div>
                    <div class="cc-info">
                        <div>
                            <label for="card-num">Exp</label>
                            <input type="text" name="expire" required>
                        </div>
                        <div>
                            <label for="card-num">CCV</label>
                            <input type="text" name="security" required>
                        </div>
                    </div>
                    <h1>
                        Total:
                    </h1>
                    <label for="total" style="font-size:20px">${total}</label>
                    <div class="btns">
                        <button style="color: #fff;" type="submit" name="action" value="Purchase">Purchase</button>
                        <button><a style="text-decoration: none;color: #fff;" href="cart.jsp">Back to cart</a></button>
                    </div>

                </form>
            </div>

        </div>
        <script src="https://kit.fontawesome.com/561cbb1cce.js" crossorigin="anonymous"></script>



    </body>
</html>

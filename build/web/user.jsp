<%-- 
    Document   : user
    Created on : Mar 16, 2023, 7:49:11 PM
    Author     : ADMIN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bear Shop</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body {
                width: 100%;
            }
            tbody input {
                border: none;
                outline: none;
                width: 100%;
                font-size: 15px;
                background: bisque;
            }
            td {
                background: bisque;
            }
            img {
                width: 80px;
                height: 80px;
                margin-left: 50%;
                transform: translateX(-50%);
            }
            .add_to_cart {
                border-radius: 5px;
                background-color: burlywood;
                cursor: pointer;
            }
            .background {
                width: 100%;
                height: 500px;
            }
            .col-md-3 {
                padding: 0;
                border-radius: 10px;
                transition: all 0.5s ease 0s;
                cursor: pointer;
                padding-left: 5px;
                padding-right: 5px;
                padding-bottom: 10px;
                margin-top: 15px;
                box-sizing: border-box;
            }
            .col-md-3:hover {
                box-shadow: 0 0.625rem 1.875rem rgba(0, 0, 0, 0.4);
            }
            .col-md-3 input {
                width: 100%;
                border: none;
                outline: none;
                text-align: center;
            }
            .col-md-3 img {
                width: 100%;
                height: 260px;
                border-radius: 10px;
            }
        </style>
    </head>
    <body>
        <c:import url="navbar.jsp"/>
        <c:set var="userLogin" value="${sessionScope.USER_LOGIN}"/>
        <c:if test="${empty userLogin}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty userLogin}">
            <c:if test="${userLogin.role eq 'admin' }">
                <c:redirect url="admin.jsp"/>
            </c:if>
        </c:if>
        <img class="background" src="./images/teddybearbackground.jpg"/>
        <c:set var="list" value="${sessionScope.BEAR_LIST}"/>
        <h2 style="text-align: center; font-family: cursive;color: #ff6683; margin:10px 0px;overflow-y: hidden">
            TEDDY BEAR COLLECTION</h2>
        <div class="container">
            <div class="row">
                <c:forEach var="list" items="${list}">
                    <div class="col-md-3">
                        <form action="DispatchController">
                            <input type="hidden" name="username" value="${sessionScope.USERNAME}"/>
                            <input type="hidden" name="bearID" value="${list.bearID}"/>
                            <img src="${list.bearImg}"/>
                            <input type="hidden" name="bearImg" value="${list.bearImg}"/>
                            <input type="text" name="bearName" value="${list.bearName}" readonly/>
                            <input type="number" name="price" value="${list.price}" readonly/>
                            <input class="add_to_cart" type="submit" name="action" value="ADD TO CART"/>
                        </form>
                    </div>
                </c:forEach>


            </div>
        </div>
        <table>
            <c:if test="${empty list}">
                <p>${requestScope.NO_RESULT_SEARCH}</p>
            </c:if>
            <tbdody>
            </tbdody>
        </table>
        <c:import url="footer.jsp"/>

    </body>
</html>

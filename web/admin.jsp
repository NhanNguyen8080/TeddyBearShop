<%-- 
    Document   : admin
    Created on : Mar 15, 2023, 4:42:42 PM
    Author     : ADMIN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Admin Page</title>
        <style>
            th, td{
                line-height: 25px; 
                border: 1px solid black; 
                padding: 5px;
            }
            th{
                background-color: gray;
            }

        </style>
    </head>
    <body>
        <c:set var="userLogin" value="${sessionScope.USER_LOGIN}"/>
        <c:if test="${empty userLogin}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test="${not empty userLogin}">
            <c:if test="${userLogin.role eq 'user' }">
                <c:redirect url="user.jsp"/>
            </c:if>
        </c:if>
        <div class="admin_header">
            <h1>WELCOME, ADMIN</h1>
            <form action="DispatchController">
                <input type="text" name="search" value="${param.search}"/>
                <input type="submit" name="action" value="Search"/>
                <input type="submit" name="action" value="Log out"/>
            </form>
        </div>
        <table>
            <c:set var="list" value="${sessionScope.USER_LIST}"/>
            <c:if test="${not empty list}">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Fullname</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th></th>
                        <th></th>

                    </tr>
                </thead>
            </c:if>
            <c:if test="${empty list}">
                <p>${requestScope.NO_RESULT_SEARCH}</p>
            </c:if>
            <tbody>
                <c:forEach var="list" items="${list}" varStatus="counter">
                <form action="DispatchController">
                    <tr>
                        <td>${counter.count}</td>
                        <td><input style="border:none; outline: none;" name="username" type="text" value="${list.username}" readonly=""/></td>
                        <td>${list.password}</td>
                        <td>${list.fullname}</td>
                        <td>${list.email}</td>
                        <td><input style="border:none; outline: none;" type="text" name="role" value="${list.role}"</td>
                        <td>
                            <input type="submit" name="action" value="Update"/>
                            <input type="hidden" name="search" value="${param.search}"/>
                        </td>
                        <td><a href="DispatchController?action=Delete&username=${list.username}&role=${list.role}&search=${param.search}">Delete</a></td>
                    </tr>
                </form>

            </c:forEach>
        </tbody>
    </table>
    <a href="ListProductsController">View products</a>
</body>
</html>

<%-- 
    Document   : productsAdmin
    Created on : Mar 16, 2023, 8:25:27 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Products</title>
        <style>
            tbody input {
                border: none;
                outline: none;
            }
        </style>
    </head>
    <body>
        <h1>WELCOME, ADMIN</h1>
        <form action="DispatchController">
            <input type="text" name="search" value="${param.search}"/>
            <input type="submit" name="action" value="SEARCH"/>
            <input type="submit" name="action" value="Log out"/>
        </form>
        <table>
            <c:set var="list" value="${sessionScope.BEAR_LIST}"/>
            <c:if test="${not empty list}">
                <thead>
                <th>NO</th>
                <th>Bear ID</th>
                <th>Bear Name</th>
                <th>Image</th>
                <th>Description</th>
                <th>Origin</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
                <th></th>
            </thead>
        </c:if>
        <c:if test="${empty list}">
            <p>${requestScope.NO_RESULT_SEARCH}</p>
        </c:if>
        <tbdody>
            <c:forEach var="list" items="${list}" varStatus="counter">
                <form action="DispatchController">
                    <tr>
                        <td>${counter.count}</td>
                        <td><input type="text" name="bearID" value="${list.bearID}"/></td>
                        <td><input type="text" name="bearName" value="${list.bearName}"/></td>
                        <td><input type="text" name="bearImg" value="${list.bearImg}"/></td>
                        <td><input type="text" name="description" value="${list.description}"/></td>
                        <td><input type="text" name="origin" value="${list.origin}"/></td>
                        <td><input type="number" name="price" value="${list.price}"/></td>
                        <td><input type="number" name="quantity" value="${list.quantity}"/></td>
                        <td>
                            <input type="submit" name="action" value="UPDATE"/>
                            <input type="hidden" name="search" value="${param.search}"
                        </td>
                        <td><a href="DispatchController?action=DeleteProduct&bearID=${list.bearID}&search=${param.search}">Delete</a></td>
                    </tr>
                </form>

            </c:forEach>
        </tbdody>
    </table>
    <a href="addProduct.jsp">Add a product</a>
</body>
</html>

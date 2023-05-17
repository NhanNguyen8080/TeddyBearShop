<%-- 
    Document   : cart
    Created on : Mar 18, 2023, 6:09:07 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            tbody input {
                border: none;
                outline: none;
                width: 100%;
                font-size: 15px;
            }
            img {
                width: 80px;
                height: 80px;
                margin-left: 50%;
                transform: translateX(-50%);
            }

            .your_cart {
                margin-top: 50px;
                margin-left: 43%;
                color: burlywood;
            }
            .active>.nav-link {
                color: rgba(0,0,0,.7) !important;
            }
            .navbar-light .navbar-nav .nav-link {
                color: rgba(0,0,0,.9);
            }
        </style>
    </head>
    <body>
        <c:import url="navbar.jsp"/>
        <h1>Welcome, ${sessionScope.USERNAME}</h1>
        <h1 class="your_cart">YOUR CART</h1>
        <a class="cart_buying" href="user.jsp">keep buying</a>
        <table class="cart_table">

            <c:set var="list" value="${sessionScope.CART_LIST}"/>
            <c:if test="${not empty list}">
                <thead class="cart_row">
                <th class="product">PRODUCT</th>
                <th>PRICE</th>
                <th>QUANTITY</th>
                <th>TOTAL</th>
            </thead>
        </c:if>
        <c:set var="total" value="${0}"/>
        <tbdody>
            <c:forEach var="list" items="${list}">
                <c:set var="total" value="${total + list.price * list.quantity} "/>
                <form action="DispatchController">
                    <tr class="cart_row">
                        <td>
                            <div class="cart_product">
                                <div class="cart_img">             
                                    <img src="${list.bearImg}"/>
                                </div>
                                <div>
                                    <div>
                                        <div class="cart_product__name">
                                            <input type="text" name="bearName" value="${list.bearName}" readonly/>
                                        </div>
                                        <div class="cart_product__delete_product">
                                            <a href="DispatchController?action=DeleteCart&username=${list.username}&bearID=${list.bearID}">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="cart_row__price">
                                <input type="number" name="price" value="${list.price}" readonly/>
                            </div>
                        </td>
                        <td>
                            <div class="cart_row__quantity">
                                <input type="number" name="quantity" value="${list.quantity}"/>
                            </div>
                        </td>
                        <td>
                            <div class="cart_row__total">
                                <input type="text" name="productTotal" value="${list.quantity * list.price}"/>
                            </div>
                        </td>

                    </tr>
                </form>
            </c:forEach>
        </tbdody>
    </table>
    <c:set var="list" value="${sessionScope.CART_LIST}"/>
    <c:if test="${not empty list}">
        <div class="total_payment">
            <div class="total">
                <h1>Total: ${total}</h1>
            </div>
            <form action="DispatchController">
                <div class="payment" >
                    <input type="hidden" name="list" value="${list}"/>
                    <button class="payment" type="submit" name="action" value="Order">ORDER</button>
                </div>
            </form>
            

        </div>
    </c:if>
    <c:if test="${empty list}">
        <h1 class="cart_message">Your shopping cart is empty</h1>
    </c:if>

</body>
</html>

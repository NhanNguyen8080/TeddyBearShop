<%-- 
    Document   : addProduct
    Created on : Mar 16, 2023, 9:29:18 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Page</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            .form-box {
                height: 750px;
            }
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form action="DispatchController"/>
                        <h2>Add a product</h2>
                        <div class="inputbox">
                            <input type="text" required name="bearID">
                            <label for="">Bear ID</label>
                        </div>
                        <div class="inputbox">
                            <input type="text" required name="bearName">
                            <label for="">Bear Name</label>
                        </div>
                        <div class="inputbox">
                            <input type="text" required name="bearImg">
                            <label for="">Bear Imgage</label>
                        </div>
                        <div class="inputbox">
                            <input type="text" required name="description">
                            <label for="">Description</label>
                        </div>
                        <div class="inputbox">
                            <input type="text" required name="origin">
                            <label for="">Origin</label>
                        </div>
                        <div class="inputbox">
                            <input type="number" required name="price">
                            <label for="">Price</label>
                        </div>
                        <div class="inputbox">
                            <input type="number" required name="quantity">
                            <label for="">Quantity</label>
                        </div>
                        <input class="submit" style="background-color: none;"type="submit" name="action" value="Add"/>
                    </form>
                    <p class="error_message">${requestScope.PRODUCT_DUPLICATE}</p>

                </div>
            </div>
        </section>

    </body>
</html>

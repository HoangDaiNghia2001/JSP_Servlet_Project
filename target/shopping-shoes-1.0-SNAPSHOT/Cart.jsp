<%-- 
    Document   : checkOut
    Created on : Nov 26, 2022, 3:43:10 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <title>Cart</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <div class="bg-img-top"></div>

        <div class="cart">            
            <div class="cart-inf">
                <div class="cart-title">
                    <h2>Total price: $ ${cart.getTotalMoney()}</h2>
                    <p>Your shopping cart contains: ${amount} products</p>
                </div>

                <div class="cart-address">
                    <div class="item">
                        <p>Phone: </p>
                        <span>${(phone != null) ? phone : "............."}</span>
                    </div>
                    <div class="item">
                        <p>Address: </p>
                        <span>${(address != null) ? address : "............."}</span>
                    </div>
                    <div class="edit">
                        <button id="edit-inf">Edit information</button>
                    </div>
                </div>
            </div>

            <div class="cart-list-product">
                <table>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Size</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Buy Now</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="o" value="${cart}"></c:set>
                        <c:set var="stt" value="0"></c:set>
                        <c:choose>
                            <c:when test="${not empty o.lstitems}">
                                <c:forEach items="${o.lstitems}" var="c">
                                    <c:set var="stt" value="${stt +1}"></c:set>
                                        <tr>
                                            <td>${stt}</td>
                                        <td>${c.product.productName}</td>
                                        <td>${c.product.getBrandName(c.product.getcID())}</td>
                                        <td>${c.size}</td>
                                        <td>$ ${c.product.productPrice*c.quantity}</td>
                                        <td class="buy-now">
                                            <a class="btn" href="/quantity?num=-1&pID=${c.product.productID}&size=${c.size}"><i class="fa-solid fa-minus"></i></a>
                                            <input type="text" name="quantity" class="form-control" value="${c.quantity}" readonly>
                                            <a class="btn" href="/quantity?num=1&pID=${c.product.productID}&size=${c.size}"><i class="fa-solid fa-plus"></i></a>
                                        </td>
                                        <td>
                                            <form action="buy-now" method="post">
                                                <input type="hidden" name="sizeItems" value="${c.size}">
                                                <input type="hidden" name="quantityItems" value="${c.quantity}">
                                                <input type="hidden" name="productID" value="${c.product.productID}">
                                                <input type="hidden" name="productName" value="${c.product.productName}">
                                                <input type="hidden" name="productPrice" value="${c.product.productPrice}">
                                                <button class="item-checkout check-out">Buy Now</button>
                                            </form>
                                        </td>
                                        <td class="remove"><a href="/remove-pro-cart?pID=${c.product.productID}&size=${c.size}"><i class="fa-solid fa-trash-can"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>

                            <c:otherwise>
                                <tr>
                                    <td colspan="8">Your shopping cart is empty</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>

            <div class="btn-action">
                <div class="cart-title__checkout">
                    <button><a href="/check-out">Check Out</a></button>
                </div>

                <div class="cart-title__return">
                    <button><a href="/shop-now?bID=101010&pageIndex=${tag}">Continue Shopping</a></button>
                </div>

            </div>
        </div>

        <div class="bill-infor ${(infor == "none") ? "action" : ""}">
            <form class="fill-infor" action="fill-infor" method="post">
                <i class="fa-solid fa-xmark" id="close"></i>
                <p>
                    Please fill in your order information
                </p>

                <div class="form-group">
                    <input type="text" name="phoneNumber" required>
                    <p>Enter your phone</p>
                </div>

                <div class="form-group">
                    <input type="text" name="address" required>
                    <p>Enter your address</p>
                </div>

                <button type="submit">
                    Submit
                </button>
            </form>
        </div>

        <%@include file="includes/footer.jsp" %>

        <script src="js/cart.js"></script>

    </body>
</html>

<%-- 
    Document   : singel
    Created on : Nov 26, 2022, 3:43:19 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <title>Single Page</title>
    </head>
    <body>
        <div class="mains">

            <%@include file="includes/navbar.jsp" %>

            <div class="bg-img-top"></div>

            <div class="sigle">

                <c:if test="${not empty brand}">
                    <div class="brand">
                        <p>Brand: <a href="/shop-now?bID=${brand.brandID}">${brand.brandName}</a></p>
                    </div>
                </c:if>

                <c:if test="${not empty product}">
                    <div class="body-content">
                        <!-- Image -->
                        <div class="body-image">
                            <div class="image">
                                <img class="img-fluid" src="./image/${product.imageLink}" onerror="this.src=`${product.imageLink}`"/>
                            </div>
                            <div class="image-zoom">
                                <p>Zoom</p>
                            </div>
                        </div>

                        <!-- Add to cart -->
                        <div class="add-to-cart">
                            <div class="card-body">
                                <div class="cart-product-infor">
                                    <p>${product.productName}</p>
                                    <p>$ ${product.productPrice}</p>
                                    <!-- <p class="price_discounted">149.90 $</p> -->
                                </div>

                                <div class="amount">
                                    <div class="amount-title">
                                        <p>Amount: <span>${product.productAmout}</span></p>
                                        <input type="hidden" id="amount" value="${product.productAmout}">
                                    </div>
                                </div>

                                <div class="desciption">
                                    <div class="desciption-title">
                                        <p>Description</p>
                                    </div>
                                    <div class="desciption-body">
                                        <p>
                                            ${product.productDescrip}
                                        </p>
                                    </div>
                                </div>

                                <!--<form method="get" action="cart.html">-->
                                <form method="get" action="add-to-cart" name="f">
                                    <%--<c:set var="id" value="${product.productID}"></c:set>--%>
                                    <input type="hidden" name="proID" value="${product.productID}">

                                    <div class="form-group">
                                        <label for="colors">Size:</label>
                                        </br>
                                        <select class="custom-select" id="size" name="size">
                                            <option selected value="38">38</option>
                                            <option value="39">39</option>
                                            <option value="40">40</option>
                                            <option value="41">41</option>
                                            <option value="42">42</option>
                                            <option value="43">43</option>

                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Quantity :</label>
                                        <div class="input-group ">
                                            <div class="input-group-item">
                                                <button type="button" id="decre" onclick="Decre()"><i class="fa-solid fa-minus"></i></button>
                                            </div>
                                            <input type="text" class="form-control" id="quantity" name="quantity" min="1"
                                                   max="100" value="1">
                                            <div class="input-group-item plus">
                                                <button type="button" id="incre" onclick="Incre()"><i class="fa-solid fa-plus"></i></button>
                                            </div>
                                        </div>
                                    </div>

                                    <c:if test="${auth.getUserAdmin() != 1}">
                                        <div class="form-group cart">
                                            <button class="add-product" type="button" onclick="buy()"><i class="fa fa-shopping-cart"></i> Add To Cart</button>
                                        </div>
                                    </c:if>
                                </form>
                                <!--</form>-->

                                <div class="product_rassurance">
                                    <ul class="list-inline">
                                        <li class="list-inline-item"><i class="fa-solid fa-truck-fast"></i></i>Fast delivery
                                        </li>
                                        <li class="list-inline-item"><i class="fa-solid fa-money-check-dollar"></i>Secure
                                            payment
                                        </li>
                                        <li class="list-inline-item"><i class="fa-solid fa-phone-volume"></i>0888346324
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>


                <div class="featured-products">
                    <div class="featured-products-title">
                        <h2>Orther Products</h2>
                    </div>


                    <div class="featured-products-list" id="content">
                        <c:forEach items="${lst4Product}" var="o">
                            <div class="product featured-products-list-item">
                                <div class="featured-products-list-item-img">
                                    <button class="quick-view"><a href="/single-page?pID=${o.productID}&brandID=${o.cID}">Quick view</a></button>
                                    <img src="./image/${o.imageLink}" onerror="this.src=`${o.imageLink}`" alt="" />
                                </div>
                                <div class="product-name">
                                    <h3>${o.productName}</h3>
                                </div>
                                <div class="featured-products-list-item__buy">
                                    <div class="featured-products-list-item__buy-price">
                                        <h5>$ ${o.productPrice}</h5>
                                        <div class="featured-products-list-item__buy-price__start">
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="list-product__item__buy-cart">
                                        <a href="/single-page?pID=${o.productID}&brandID=${o.cID}"><i class="fa-solid fa-cart-shopping"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                    <c:if test="${a == b}">
                        <div class="load-more-other-product">
                            <button onclick="loadMore()"><p>Load more</p></button>
                        </div>
                    </c:if>

                </div>

                <c:if test="${not empty product}">
                    <div class="showImage">
                        <div class="modal" id="modal">
                            <div class="modal-header">
                                <h5 class="modal-title" id="productModalLabel">${product.productName}</h5>
                                <i class="fa-solid fa-xmark"></i>
                            </div>
                            <div class="modal-body">
                                <img class="img-fluid" src="./image/${product.imageLink}" onerror="this.src=`${product.imageLink}`"/>
                            </div>
                            <div class="modal-footer">
                                <p>Price: <span> $ ${product.productPrice}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
            <%@include file="includes/footer.jsp" %>

        </div>
        <script src="js/single.js"></script>
        <script src="js/navbar.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                                function loadMore() {
                                    var amount = document.getElementsByClassName("product").length;
                                    $.ajax({
                                        url: "/load-more-product",
                                        type: "get", //send it through get method
                                        data: {
                                            count: amount
                                        },
                                        success: function (data) {
                                            var row = document.getElementById("content");
                                            row.innerHTML += data;
                                        },
                                        error: function (xhr) {
                                            //Do Something to handle error
                                        }
                                    });
                                }

                                var a = document.getElementById("quantity");
                                var amount = document.getElementById("amount").value;
                                var quantity = document.getElementById("quantity").value;
                                var btnDecre = document.getElementById("decre");
                                var btnIncre = document.getElementById("incre");

                                function Decre()
                                {
                                    quantity *= 1;
                                    quantity--;
                                    a.value = quantity;
                                    if (quantity <= 1) {
                                        quantity = 1;
                                        a.value = quantity;

                                    } else {
                                        a.value = quantity;
                                    }

                                }

                                function Incre()
                                {
                                    quantity *= 1;
                                    quantity++;
                                    if (quantity > (amount * 1)) {
                                        quantity = amount * 1;
                                        a.value = quantity;
                                    } else {
                                        a.value = quantity;
                                    }
                                }

                                function buy()
                                {
                                    var amount = document.f.quantity.value;
                                    var size = document.f.size.value;
                                    var pID = document.f.proID.value;
                                    document.f.action = "add-to-cart?pID=" + pID + "&quantity=" + amount + "&size=" + size;
                                    document.f.submit();
                                }
        </script>

    </body>
</html>

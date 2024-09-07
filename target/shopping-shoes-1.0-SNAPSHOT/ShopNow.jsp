<%-- 
    Document   : ShopNơ
    Created on : Nov 26, 2022, 3:32:07 PM
    Author     : Administrator
--%>

<%@page import="com.dao.BrandDao"%>
<%@page import="com.model.Brand"%>
<%@page import="java.util.*"%>
<%@page import="com.model.Product"%>
<%@page import="com.dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>

        <title>Show Now</title>
    </head>
    <body>
        <div class="main">
            <%@include file="includes/navbar.jsp" %>

            <div class="bg-img-top"></div>

            <div class="body">
                <!-- left -->
                <div class="slideBar">
                    <form action="search-product" class="slideBar__search-all">
                        <div class="slideBar__search">
                            <h2>Search here...</h2>
                            <div class="slideBar__search-item">
                                <input oninput="searchByAjax(this)" type="text" name="product_name" placeholder="Product name..." value="${search}"/>
                            </div>
                        </div>
                        <div class="slideBar__price">
                            <h2>Price Range $</h2>
                            <div class="price-input">
                                <input oninput="getProByPrice()" type="number" id="input-min" name="min" value="${(priceMin == null) ? min : priceMin}" />
                                <i class="fa-solid fa-window-minimize"></i>
                                <input oninput="getProByPrice()" type="number" id="input-max" name="max" value="${(priceMax == null) ? max : priceMax}" />
                            </div>
                            <div class="search">
                                <button type="submit">Search</button>
                            </div>
                        </div>
                    </form>

                    <div class="slideBar__occasion">
                        <h2>Brand</h2>

                        <div class="slideBar__occasion-item ${brandID == 101010 && check =="" ? "active" :""}">
                            <i class="fa-regular fa-square-check"></i>
                            <a href="/shop-now?bID=101010"><p>All Products</p><span>(${countAllPro})</span></a>
                        </div>

                        <c:forEach items="${lstBrand}" var="b">

                            <div class="slideBar__occasion-item ${brandID == b.brandID && check =="" ? "active" :""}">
                                <i class="fa-regular fa-square-check"></i>
                                <a href="/shop-now?bID=${b.brandID}"><p>${b.brandName }</p><span>(${b.amountProduct})</span></a>
                            </div>
                        </c:forEach>
                    </div>


                    <div class="slideBar__review">
                        <h2>Customer Review</h2>

                        <div class="slideBar__review-item five-start">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <p>5.0</p>
                        </div>
                        <div class="slideBar__review-item four-start">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <p>4.0</p>
                        </div>

                        <div class="slideBar__review-item three-start">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <p>3.0</p>
                        </div>
                        <div class="slideBar__review-item two-start">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <p>2.0</p>
                        </div>
                        <div class="slideBar__review-item one-start">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <p>1.0</p>
                        </div>
                    </div>

                    <div class="slideBar__deal">
                        <h2>Special Deal</h2>
                        <c:forEach items="${lst5Product}" var="p">

                            <div class="slideBar__deal-item">
                                <div class="slideBar__deal-item__img">
                                    <img src="./image/${p.imageLink}" onerror="this.src=`${p.imageLink}`" alt="" />
                                </div>

                                <div class="slideBar__deal-item__describe">
                                    <a href="/single-page?pID=${p.productID}&brandID=${p.cID}">
                                        <h4>${p.productName}</h4>
                                        <span>$ ${p.productPrice}</span>
                                    </a>
                                </div>
                            </div>

                        </c:forEach>
                    </div>

                    <div class="slideBar__last-product">
                        <h2>Last Product</h2>
                        <c:if test="${not empty lastProduct}">
                            <div class="last-product">           
                                <div class="last-product__img">
                                    <button class="quick-view"><a href="/single-page?pID=${lastProduct.productID}&brandID=${lastProduct.cID}">Quick view</a></button>
                                    <img src="./image/${lastProduct.imageLink}" onerror="this.src=`${lastProduct.imageLink}`" alt="" />
                                </div>

                                <div class="product-name">
                                    <h3>${lastProduct.productName}</h3>

                                </div>

                                <div class="list-product__item__buy">
                                    <div class="list-product__item__buy-price">
                                        <h5>$ ${lastProduct.productPrice}</h5>
                                        <div class="list-product__item__buy-price__start">
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                            <i class="fa-solid fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="list-product__item__buy-cart">
                                        <a href="/single-page?pID=${lastProduct.productID}&brandID=${lastProduct.cID}"><i class="fa-solid fa-cart-shopping"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>

                <div class="content">
                    <div class="sale">
                        <div class="sale-item">
                            <h2>40% Off</h2>
                            <img src="./image/sale13.jpg" alt="" />
                        </div>

                        <div class="sale-item">
                            <h2>50% Off</h2>
                            <img src="./image/sale2.jpg" alt="" />
                        </div>
                    </div>

                    <div id="content" class="list-product">
                        <c:choose>
                            <c:when test="${lstProduct.size() > 0}">
                                <c:forEach items="${lstProduct}" var="p">
                                    <div class="product list-product__item">                                                                                   
                                        <div class="list-product__item-img">
                                            <button class="quick-view"><a href="/single-page?pID=${p.productID}&brandID=${p.cID}">Quick view</a></button>
                                            <img src="./image/${p.imageLink}" onerror="this.src=`${p.imageLink}`" alt="" />
                                        </div>
                                        <div class="product-name">
                                            <h3>${p.productName}</h3>
                                        </div>
                                        <div class="list-product__item__buy">
                                            <div class="list-product__item__buy-price">
                                                <h5>$ ${p.productPrice}</h5>
                                                <div class="list-product__item__buy-price__start">
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                </div>
                                            </div>
                                            <div class="list-product__item__buy-cart">
                                                <a href="/single-page?pID=${p.productID}&brandID=${p.cID}"><i class="fa-solid fa-cart-shopping"></i></a>
                                            </div>
                                        </div>
                                    </div>                              
                                </c:forEach>
                            </c:when>

                            <c:otherwise>
                                <p class="no-product">There are no products matching your request :((</p>
                            </c:otherwise>

                        </c:choose>
                    </div>

                    <c:choose>
                        <c:when test="${empty check}">
                            <div class="next-page">
                                <c:if test="${tag > 1}">
                                    <a href="/shop-now?bID=${brandID}&pageIndex=${tag-1}"><i class="fa-solid fa-chevron-left"></i></a>
                                    </c:if>

                                <c:forEach begin="1" end="${endPage}" var="i"> 
                                    <a class="${tag == i ? "click":""}" href="/shop-now?bID=${brandID}&pageIndex=${i}">${i}</a>
                                </c:forEach>

                                <c:if test="${tag < endPage}">
                                    <a class="" href="/shop-now?bID=${brandID}&pageIndex=${tag+1}"><i class="fa-solid fa-chevron-right"></i></a>
                                    </c:if>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <c:if test="${lstProduct.size() > 0}">
                                <div class="load-more-other-product">
                                    <button onclick="loadMoreProductBySearch()"> <p>Load more</p> </button>
                                </div>
                            </c:if>
                        </c:otherwise>
                    </c:choose>

                    <div class="sale">
                        <div class="sale-item">
                            <h2>21% Off</h2>
                            <img src="./image/sale3.jpg" alt="" />
                        </div>

                        <div class="sale-item">
                            <h2>31% Off</h2>
                            <img src="./image/sale4.jpg" alt="" />
                        </div>
                    </div>

                </div>
            </div>

            <%@include file="includes/footer.jsp" %>
        </div>

        <script src="js/navbar.js"></script>
        <script src="js/ShopNow.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                                        function loadMoreProductBySearch() {
                                            var amount = document.getElementsByClassName("product").length;
                                            $.ajax({
                                                url: "/load-more-product-search",
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

                                        function getProByPrice() {
                                            var price_min = document.getElementById("input-min").value;
                                            var price_max = document.getElementById("input-max").value;

                                            $.ajax({
                                                url: "/range-price",
                                                type: "get", //send it through get method
                                                data: {
                                                    priceMax: price_max,
                                                    priceMin: price_min
                                                },
                                                success: function (data) {
                                                    var row = document.getElementById("content");
                                                    row.innerHTML = data;

                                                },
                                                error: function (xhr) {
                                                    //Do Something to handle error
                                                }
                                            });
                                        }

                                        function searchByAjax(param) {
                                            var txtSearch = param.value;
                                            $.ajax({
                                                url: "/search-by-javax",
                                                type: "get", //send it through get method
                                                data: {
                                                    product_name: txtSearch
                                                },
                                                success: function (data) {
                                                    var row = document.getElementById("content");
                                                    row.innerHTML = data;
                                                },
                                                error: function (xhr) {
                                                    //Do Something to handle error
                                                }
                                            });
                                        }
        </script>
    </body>
</html>

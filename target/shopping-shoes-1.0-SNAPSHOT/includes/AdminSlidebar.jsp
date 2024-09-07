<%-- 
    Document   : AdminSlidebar
    Created on : Dec 10, 2022, 6:53:26 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="manage-slidebar">
    <ul>
        <li>
            <a href="/admin-manager-product?pIndex=1">Page Admin</a>
        </li>
        <li>
            <form action="admin-search-product" method="post">
                <input name="productID" type="text" value="${productId}" placeholder="Seacrh by ID ..." required="">
                <button type="submit">Search</button>
            </form>
        </li>
        <li >
            <a class="${(clicked == "manage-pro") ? "active":""}" href="/admin-manager-product?pIndex=1">
                Manager Product
            </a>
        </li>
        <li>
            <a class="${(clicked == "add-admin") ? "active":""}" href="/admin-add-new-admin">
                Add new Admin
            </a>
        </li>
        <li>
            <a class="${(clicked == "change-admin") ? "active":""}" href="/admin-change-infor-admin">
                Change Infor Of Admin
            </a>
        </li>
        <li>
            <a class="${(clicked == "revenue-admin") ? "active":""}" href="/admin-revenue-of-fashion-feet">
                Revenue
            </a>
        </li>

    </ul>

    <div class="amount-pro">
        <p>
            Amount Product
        </p>
        <div class="amount-pro__item">
            <p>
                All products: 
            </p>
            <span>${countAllPro}</span>
        </div>
        <c:forEach var="b" items="${lstBrand}">
            <div class="amount-pro__item">
                <p>
                    ${b.brandName}: 
                </p>
                <span>${b.amountProduct}</span>
            </div>
        </c:forEach>     
    </div>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
    <div class="header__brand">
        <a href="/home">
            <span>FASHION</span>
            <i>FEET</i>
        </a>
    </div>
    <ul class="header__navbar">
        <li>
            <a href="/home">
                Home
                <span></span>
            </a>
        </li>
        <c:if test="${not empty auth and auth.getUserAdmin() == 1}">
            <li>
                <a href="/admin-manager-product">
                    Admin
                    <span></span>
                </a>
            </li>
        </c:if>
        <li>
            <a href="/shop-now?bID=101010">
                Shop Now
                <span></span>
            </a>
        </li>
        <li>
            <a href="/about-us">
                About
                <span></span>
            </a>
        </li>
        <li>
            <a href="/contact-us">
                Contact
                <span></span>
            </a>
        </li>

        <c:if test="${not empty auth and auth.getUserAdmin() == 1}">
            <li>
                <a href="/log-out" title="Log out">
                    <i class="fa-solid fa-right-from-bracket"></i>
                </a>
            </li>
        </c:if>

        <c:if test="${not empty auth and auth.getUserAdmin() != 1}">
            <li>
                <i class="btnLike fa-solid fa-heart"></i>
            </li>
            <li>
                <a href="/cart-list"><i class="fa-solid fa-cart-plus"><span class="cart-product-amout">${(amount > 0) ? amount : 0}</span></i></a>
            </li>
            <li>
                <a href="/log-out" title="Log out">
                    <i class="fa-solid fa-right-from-bracket"></i>
                </a>
            </li>
        </c:if>

        <c:if test="${empty auth}">
            <li>
                <a href="/user-login">
                    Login
                    <span></span>
                </a>

            </li>
        </c:if>
    </ul>
</div>

<!-- thanks-box -->
<div class="toasts">

</div>

<!-- search-box -->
<!--<form action="search-product" class="box-search hide">
    <input oninput="searchByAjax(this)" class="box-search__input" type="text" name="product_name" value="" placeholder="Click enter after typing ... ">
    <button type="submit" >Search</button>
</form>-->

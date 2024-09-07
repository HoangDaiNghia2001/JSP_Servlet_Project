<%-- 
    Document   : PageAdmin
    Created on : Dec 10, 2022, 6:53:08 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/CssPageAdmin.jsp" %>
        <title>Admin Page</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>

        <div class="bg-img-top"></div>

        <div class="manager">
            <%@include file="includes/AdminSlidebar.jsp" %>
            <table>
                <thead>
                    <tr>
                        <th class="tb-header" colspan="3">
                            <a href="/admin-manager-product?pIndex=1">
                                Manager Product
                            </a>
                        </th>
                        <th colspan="4">
                            <div class="manager-action">
                                <form action="/delete-product">
                                    <input id="arrCheck" type="hidden" name="checked">
                                    <button onclick="arrValue()">
                                        Delete
                                    </button>
                                </form>
                                <button id="add-new-pro">
                                    Add new product
                                </button>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>
                            <i class="fa-regular fa-square-check"></i>
                        </th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Amount</th>
                        <th>Actions</th>
                    </tr>

                    <c:choose>
                        <c:when test="${lstProPageAdmin.size() > 0}">
                            <c:forEach var="p" items="${lstProPageAdmin}">
                                <tr>
                                    <td>
                                        <input name="valueCheckbox" type="checkbox" value="${p.productID}">
                                    </td>
                                    <td>
                                        ${p.productID}
                                    </td>
                                    <td>
                                        ${p.productName}
                                    </td>
                                    <td class="img-product">
                                        <img src="./image/${p.imageLink}" onerror="this.src=`${p.imageLink}`" alt="">
                                    </td>
                                    <td>
                                        $ ${p.productPrice}
                                    </td>
                                    <td>
                                        ${p.productAmout}
                                    </td>
                                    <td>
                                        <!--change-->
                                        <button class="change">
                                            <i class="fa-solid fa-pen"></i>
                                        </button>
                                        <!--form-change-->
                                        <div class="change-pro">
                                            <form action="change-inf-product" method="post">
                                                <p>Change Information</p>
                                                <div class="change-pro__item">
                                                    <p>ID Product</p>
                                                    <input type="text" name="pro-id" value="${p.productID}" readonly>
                                                </div>
                                                <div class="change-pro__item">
                                                    <p>Name</p>
                                                    <input type="text" name="pro-name" value="${p.productName}" required>
                                                </div>
                                                <div class="change-pro__item">
                                                    <p>Price ($)</p>
                                                    <input type="number" name="pro-price" value="${p.productPrice}" required>
                                                </div>
                                                <div class="change-pro__item">
                                                    <p>Amount</p>
                                                    <input type="number" name="pro-amount" value="${p.productAmout}" required>
                                                </div>
                                                <div class="change-pro__item">
                                                    <p>Image Link</p>
                                                    <input type="text" name="pro-link" value="${p.imageLink}" required>
                                                </div>
                                                <div class="change-pro__item">
                                                    <p>Description</p>
                                                    <textarea name="pro-descrip"cols="10" rows="4" required>${p.productDescrip}</textarea>
                                                </div>
                                                <div class="change-pro__item">
                                                    <p>Category</p>
                                                    <select name="pro-cateID">
                                                        <c:forEach var="b" items="${lstBrand}">
                                                            <option value="${b.brandID}" ${(b.brandID == p.cID)? "selected":""}>${b.brandName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="change-pro-action">
                                                    <button type="button">Cancel</button>
                                                    <button type="submit">Update</button>
                                                </div>
                                            </form>
                                        </div>

                                        <!--delete-->
                                        <button class="delete">
                                            <i class="fa-regular fa-trash-can"></i>
                                        </button>
                                        <!--form-delete-->
                                        <div class="question">
                                            <div class="question-item">
                                                <p>Are you sure you want to delete products with id equal to ${p.productID} ?</p>
                                                <button>Cancle</button>
                                                <a href="/admin-remove-product?proId=${p.productID}">Yes</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>

                        <c:otherwise>
                            <tr>
                                <td colspan="7">
                                    There are no products matching the id you are looking for :(((
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>

                    <c:if test="${not empty clicked}">
                        <tr  class="page">
                            <td colspan="7">
                                <div class="next-page">

                                    <c:if test="${flag > 1}">
                                        <a href="/admin-manager-product?pIndex=${flag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                        </c:if>

                                    <c:forEach var="i" begin="1" end="${amountPage}">
                                        <a class="${flag == i ? "click" : ""}" href="/admin-manager-product?pIndex=${i}">${i}</a>
                                    </c:forEach>

                                    <c:if test="${flag < amountPage}">
                                        <a href="/admin-manager-product?pIndex=${flag + 1}"><i class="fa-solid fa-chevron-right"></i></a>
                                        </c:if>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                </tbody>

            </table>
            <div class="add-pro ">
                <form action="add-new-product" method="post">
                    <p>Add Product</p>
                    <div class="add-pro__item">
                        <p>Name</p>
                        <input type="text" name="pro-name" required>
                    </div>
                    <div class="add-pro__item">
                        <p>Price ($)</p>
                        <input type="number" name="pro-price" required>
                    </div>
                    <div class="add-pro__item">
                        <p>Amount</p>
                        <input type="number" name="pro-amount" required>
                    </div>
                    <div class="add-pro__item">
                        <p>Image Link</p>
                        <input type="text" name="pro-link" required>
                    </div>
                    <div class="add-pro__item">
                        <p>Description</p>
                        <textarea id="" cols="10" rows="4" name="pro-descrip" required></textarea>
                    </div>
                    <div class="add-pro__item">
                        <p>Category</p>
                        <select name="pro-cateID">
                            <c:forEach var="b" items="${lstBrand}">
                                <option value="${b.brandID}">${b.brandName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="add-pro-action">
                        <button type="button">Cancel</button>
                        <button type="submit">Add</button>
                    </div>
                </form>
            </div>

        </div>
        <%@include file="includes/footer.jsp" %>

        <script src="js/manager.js"></script>
        <script>
                                        var valueCheck = document.getElementById("arrCheck");
                                        var arr = document.querySelectorAll("td > input");
                                        var rs = "";
                                        function arrValue() {
                                            for (var i = 0; i < arr.length; i++) {
                                                if (arr[i].checked) {
                                                    rs += arr[i].value + ",";
                                                }
                                            }
                                            valueCheck.value = rs;
                                        }

        </script>
    </body>
</html>

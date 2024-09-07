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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="css/Revenue.css">
        <link rel="icon" href="./image/shoes.png" type="image/x-icon">
        <title>Revenue</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>

        <div class="bg-img-top"></div>

        <div class="manager">
            <%@include file="includes/AdminSlidebar.jsp" %>
            <div class="revenue">
                <div class="revenue-title">
                    <a href="/admin-revenue-of-fashion-feet">Revenue of Fashion Feet</a>
                </div>
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Sold</th>
                    <th>Price</th>
                    </thead>
                    <tbody>
                        <%--<c:if test="${lstRevenue != null}">--%>
                            <c:forEach items="${lstRevenue}" var="r">
                                <tr>
                                    <td>${r.pID}</td>
                                    <td>${r.getNameOfProduct(r.pID)}</td>
                                    <td>${r.pAmount}</td>
                                    <td>$ ${r.pPrice}</td>
                                </tr>
                            </c:forEach>

                        <%--</c:if>--%>                     
                        <tr>
                            <td colspan="3">
                                Total
                            </td>
                            <td colspan="1">
                                $ ${totalPrice}
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>

    </body>
</html>

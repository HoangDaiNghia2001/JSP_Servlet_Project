<%-- 
    Document   : ForgotPassword
    Created on : Dec 6, 2022, 11:36:57 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="css/ForgotPass.css">
        <title>Forgot Password</title>
    </head>
    <body>
        <div class="main">
            <form class="forgot-pass" method="post" action="forgot-password">
                <h1>Forgot your password?</h1>
                <div class="input-item">
                    <p>Email</p>
                    <input type="email" name="emailForgot" value="${cookie.cEmail.value}" required="">
                    <i class="fa-solid fa-envelope"></i>
                </div>
                <button type="submit">
                    Get New Password
                    <span></span>
                </button>
                <span>
                    <a href="/user-login">Back to login</a>
                </span>
            </form>
        </div>
    </body>
</html>

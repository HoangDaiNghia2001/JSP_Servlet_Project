<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="css/ValidateOtp.css">
        <title>Validate OTP</title>
    </head>
    <body>
        <div class="main">
            <form class="validate-otp" action="validate-otp" method="post">
                <i class="fa-solid fa-lock"></i>
                <h1>Enter OTP</h1>
                <p>${message}</p>
                <div class="input-item">
                    <p>OTP:</p>
                    <input type="text" name="otpvalue" required>
                    <i class="fa-solid fa-envelope"></i>
                </div>
                <button type="submit">
                    Reset Password
                    <span></span>
                </button>
            </form>
        </div>
    </body>
</html>

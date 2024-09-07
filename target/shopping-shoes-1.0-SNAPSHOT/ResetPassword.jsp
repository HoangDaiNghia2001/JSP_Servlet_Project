<%-- 
    Document   : ResetPassword
    Created on : Dec 7, 2022, 1:02:20 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="css/ResetPassword.css">
        <title>Reset Password</title>
    </head>
    <body>
        <div class="main">
            <form class="reset-pass" action="reset-password" method="post">
                <input type="hidden" id="action" value="${status}">
                <h1>Reset Password</h1>
                <div class="input-item">
                    <p>Password</p>
                    <input type="password" name="password" required>
                    <i class="fa-solid fa-key"></i>
                </div>

                <div class="input-item">
                    <p>Repeat</p>
                    <input type="password" name="confPassword" required>
                    <i class="fa-solid fa-key"></i>
                </div>

                <button type="submit">
                    Reset
                    <span></span>
                </button>
            </form>
        </div>

        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
            var result = document.getElementById("action").value;
            if (result == "resetFailed")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Failed',
                    text: 'Reset Password Failed !!!',
                })
            }
        </script>
    </body>
</html>

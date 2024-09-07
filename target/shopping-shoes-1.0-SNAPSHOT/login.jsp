<%-- 
    Document   : login
    Created on : Nov 26, 2022, 3:27:58 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="css/Login.css">
        <title>Login</title>
    </head>
    <body>
        <div class="main">
            <!--login-->
            <form method="post" action="user-login" class="login-form loginActive">
                <h1>Sign in</h1>
                <div class="input-item">
                    <p>Email</p>
                    <input type="email" name="user-email" value="${cookie.cEmail.value}" required>
                    <i class="fa-solid fa-envelope"></i>
                </div>
                <div class="input-item">
                    <p>Password</p>
                    <input type="password" name="user-password" required>
                    <i class="fa-solid fa-key"></i>
                </div>

                <div class="forgot-remember">
                    <div class="remember">
                        <input type="checkbox" name="remember" value="On" ${cookie.cRemember.value == "On" ? "checked": ""}>
                        <span>Remember me</span>
                    </div>

                    <div class="forgot">
                        <a href="/forgot-password">Forgot Password?</a>
                    </div>
                </div>
                        
                <button type="submit">
                    Login
                    <span></span>
                </button>
                <span>
                    Sign Up
                </span>
                <p>Or Sign in with social platform</p>
                <div class="social-platform">
                    <div class="icon-item">
                        <i class="fa-brands fa-facebook-f"></i>
                        <span></span>
                    </div>
                    <div class="icon-item">
                        <i class="fa-brands fa-instagram"></i>
                        <span></span>
                    </div>
                    <div class="icon-item">
                        <i class="fa-brands fa-twitter"></i>
                        <span></span>
                    </div>
                    <div class="icon-item">
                        <i class="fa-brands fa-google"></i>
                        <span></span>
                    </div>
                </div>
            </form>
            <input type="hidden" id="action" value="${status}">

            <!--logout-->
            <form class="signup-form signupHide" action="sign-up" method="post">
                <h1>Sign up</h1>
                <div class="input-item">
                    <p>Username</p>
                    <input type="text" name="user-name-sigup" required>
                    <i class="fa-solid fa-user"></i>
                </div>
                <div class="input-item">
                    <p>Email</p>
                    <input type="email" name="user-email-sigup" required>
                    <i class="fa-solid fa-envelope"></i>
                </div>
                <div class="input-item">
                    <p>Password</p>
                    <input type="password" name="user-pass-sigup" required>
                    <i class="fa-solid fa-key"></i>
                </div>
                <div class="input-item">
                    <p>Repeat</p>
                    <input type="password" name="user-repeat-sigup" required>
                    <i class="fa-solid fa-key"></i>
                </div>
                <button type="submit">
                    SignUp
                    <span></span>
                </button>
                <span>
                    Login
                </span>
                <p>Or Sign in with social platform</p>
                <div class="social-platform">
                    <div class="icon-item">
                        <i class="fa-brands fa-facebook-f"></i>
                        <span></span>
                    </div>
                    <div class="icon-item">
                        <i class="fa-brands fa-instagram"></i>
                        <span></span>
                    </div>
                    <div class="icon-item">
                        <i class="fa-brands fa-twitter"></i>
                        <span></span>
                    </div>
                    <div class="icon-item">
                        <i class="fa-brands fa-google"></i>
                        <span></span>
                    </div>
                </div>
            </form>
        </div>
        <script src="js/login.js"></script>

        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
            var result = document.getElementById("action").value;
            var fromSignup = document.querySelector(".signup-form");
            var fromLogin = document.querySelector(".login-form");

            function DisplaySigUp()
            {
                fromSignup.classList.remove("signupHide");
                fromSignup.classList.add("signupActive");

                fromLogin.classList.remove("loginActive");
                fromLogin.classList.add("loginHide");
            }

            function DisplayLogin()
            {
                fromSignup.classList.add("signupHide");
                fromSignup.classList.remove("signupActive");

                fromLogin.classList.add("loginActive");
                fromLogin.classList.remove("loginHide");
            }

            if (result === "wrong pass")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Wrong Password !!!'
                });
            } else if (result === "sigup")
            {
                Swal.fire('You do not have an account please create a new account');

                Swal.fire({
                    icon: 'warning',
                    title: 'Sigup',
                    text: 'You do not have an account please create a new account !!!'
                });

                DisplaySigUp();

            } else if (result === "not match")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Passwords do not match !!!'
                });

                DisplaySigUp();
            } else if (result === "email exist")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Email already exists !!!'
                });

                DisplaySigUp();
            } else if (result === "success")
            {
                Swal.fire({
                    icon: 'success',
                    title: 'Successfully',
                    text: 'Successful account creation please login !!!'
                });

                DisplayLogin();
            }else if (result === "resetSuccess")
            {
                Swal.fire({
                    icon: 'success',
                    title: 'Successfully',
                    text: 'Reset Password Successful !!!'
                });

                DisplayLogin();
            }else if (result === "resetFailed")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Failed',
                    text: 'Reset Password Failed !!!'
                });

                DisplayLogin();
            }
        </script>

    </body>
</html>

<%-- 
    Document   : ChangeInforAdmin
    Created on : Dec 15, 2022, 7:13:34 AM
    Author     : Administrator
--%>

<%-- 
    Document   : AddNewAdmin
    Created on : Dec 14, 2022, 10:58:59 PM
    Author     : Administrator
--%>
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
        <title>Add Admin</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>

        <div class="bg-img-top"></div>

        <div class="manager">
            <%@include file="includes/AdminSlidebar.jsp" %>

            <div class="add-new-admin">
                <div class="add-new-admin__title">
                    <a href="/admin-change-infor-admin">Change Information Of Admin</a>
                </div>
                <form action="admin-change-infor-admin" method="post">
                    <input type="hidden" id="status" value="${notify}">

                    <p>Change Information </p>
                    <input type="hidden" name="ad-id" value="${auth.getUserId()}">

                    <div class="input-item">
                        <p>Email</p>
                        <input type="email" name="ad-email" value="${auth.getUserEmail()}" required>
                    </div>

                    <div class="input-item">
                        <p>Admin Name</p>
                        <input type="text" name="ad-name" value="${auth.getUserName()}" required>
                    </div>

                    <div class="input-item">
                        <p>Password</p>
                        <input type="password" name="ad-pass" required>
                    </div>

                    <div class="input-item">
                        <p>Repeat password</p>
                        <input type="password" name="ad-repeat" required>
                    </div>

                    <div class="input-item">
                        <p>Are you still an admin?</p>
                        <select name="ad-isAdmin">
                            <option value="1">Yes</option>
                            <option value="2">No</option>
                        </select>
                    </div>

                    <div class="submit">
                        <button type="submit">Change Inf</button>
                    </div>
                </form>

            </div>

        </div>
        <%@include file="includes/footer.jsp" %>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
            var result = document.getElementById("status").value;
            if (result === "not matched")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Passwords do not match !!!'
                });
            } else if (result === "email existed")
            {
                Swal.fire({
                    icon: 'error',
                    title: 'Failed',
                    text: 'Email is already existed !!!'
                });
            }
        </script>
    </body>
</html>



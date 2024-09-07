<%-- 
    Document   : about
    Created on : Nov 26, 2022, 3:01:12 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <title>About Us</title>
    </head>
    <body>
        <div class="main">

            <%@include file="includes/navbar.jsp" %>

            <!-- bg-top -->
            <div class="bg-img-top">
            </div>

            <!-- title -->
            <div class="title">
                <h1>About Us</h1>
                <p>Add Some Description</p>
            </div>

            <!-- welcome-to -->
            <div class="welcome-to">
                <div class="welcome-to__img">
                    <img src="./image/about-us.jpg" alt="" />
                </div>
                <div class="welcome-to_title">
                    <h2>Welcome to Fashion Feet</h2>
                    <p>
                        Etiam faucibus viverra libero vel efficitur. Ut semper nisl ut
                        laoreet ultrices. Maecenas dictum arcu purus, sit amet volutpat
                        purus viverra sit amet. Quisque lacinia quam sed tortor interdum,
                        malesuada congue nunc ornare. Cum sociis In semper lorem eget tortor
                        pulvinar ultricies.
                    </p>
                    <p>
                        Etiam faucibus viverra libero vel efficitur. Ut semper nisl ut
                        laoreet ultrices. Maecenas dictum arcu purus, sit amet volutpat
                        purus viverra sit amet. Quisque lacinia quam sed tortor interdum,
                        malesuada congue nunc ornare. Cum sociis . In semper lorem eget
                        tortor pulvinar ultricies.
                    </p>
                </div>
            </div>

            <!-- introduce -->
            <div class="introduce">
                <!-- member -->
                <div class="introduce__member">
                    <h2>Who We Are</h2>

                    <div class="introduce__member-item">
                        <div class="introduce__member-item-title">
                            <i class="fa-sharp fa-solid fa-plus"></i>
                            <label for="acc1">
                                <p>Group 11</p>
                            </label>
                        </div>
                        <div class="introduce__member-item-describe">
                            <p>
                                Three in One Squad consists of Nghia, Dat and Phong , we
                                specialize in making websites about renting or buying certain
                                products in real life topics for students studying Information
                                Technology and Web Programming. As a student myself, we know how
                                difficult it is for you to successfully understand this subject.
                                Since September 2021, we have been refining our skills in java
                                web programming.
                            </p>
                        </div>
                    </div>

                    <div class="introduce__member-item">
                        <div class="introduce__member-item-title">
                            <!-- <input type="radio" name="acc" id="acc2"> -->
                            <i class="fa-sharp fa-solid fa-plus"></i>
                            <label for="acc2">
                                <p>Hoàng Đại Nghĩa</p>
                            </label>
                        </div>
                        <div class="introduce__member-item-describe">
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse
                                cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                cupidatat non proident, sunt in culpa qui officia deserunt
                                mollit anim id est laborum.
                            </p>
                        </div>
                    </div>
                    <div class="introduce__member-item">
                        <div class="introduce__member-item-title">
                            <!-- <input type="radio" name="acc" id="acc3"> -->
                            <i class="fa-sharp fa-solid fa-plus"></i>
                            <label for="acc3">
                                <p>Vũ Tiến Đạt</p>
                            </label>
                        </div>
                        <div class="introduce__member-item-describe">
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse
                                cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                cupidatat non proident, sunt in culpa qui officia deserunt
                                mollit anim id est laborum.
                            </p>
                        </div>
                    </div>
                    <div class="introduce__member-item">
                        <div class="introduce__member-item-title">
                            <!-- <input type="radio" name="acc" id="acc4"> -->
                            <i class="fa-sharp fa-solid fa-plus"></i>
                            <label for="acc4">
                                <p>Nguyễn Thanh Phong</p>
                            </label>
                        </div>
                        <div class="introduce__member-item-describe">
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse
                                cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                                cupidatat non proident, sunt in culpa qui officia deserunt
                                mollit anim id est laborum.
                            </p>
                        </div>
                    </div>
                </div>

                <!-- skills -->
                <div class="introduce__skills">
                    <div class="introduce__skills-content">
                        <h2>Our Skills</h2>
                        <div class="introduce__skills-content-item one">
                            <h4>Development</h4>
                            <h4>95%</h4>
                        </div>
                        <div class="introduce__skills-content-item two">
                            <h4>Pricing</h4>
                            <h4>85%</h4>
                        </div>
                        <div class="introduce__skills-content-item three">
                            <h4>Production</h4>
                            <h4>90%</h4>
                        </div>
                        <div class="introduce__skills-content-item four">
                            <h4>Advertising</h4>
                            <h4>86%</h4>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="includes/footer.jsp" %>

        </div>

        <script src="js/navbar.js"></script>
        <script src="js/about.js"></script>

    </body>
</html>

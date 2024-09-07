<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <title>Home Page</title>
    </head>

    <body>
        <div class="home">
            <!-- navbar -->

            <%@include file="includes/navbar.jsp" %>

            <!-- background -->

            <div class="slider home">

                <img class="img-slide active" src="./image/running.jpg"></img>
                <img class="img-slide" src="./image/running2.jpg"></img>
                <img class="img-slide" src="./image/running3.jpg"></img>
                <img class="img-slide" src="./image/running4.jpg"></img>
                <img class="img-slide" src="./image/running5.jpg"></img>
                <img class="img-slide" src="./image/running6.jpg"></img>

                <div class="slogan active">
                    <h1>Nike</h1>
                    <p>SEE HOW GOOD THEY FEEL</p>
                </div>
                <div class="slogan">
                    <h1>Puma</h1>
                    <p>SEE HOW GOOD THEY FEEL</p>
                </div>
                <div class="slogan">
                    <h1>Sneakers</h1>
                    <p>SEE HOW GOOD THEY FEEL</p>
                </div>
                <div class="slogan">
                    <h1>Nike</h1>
                    <p>SEE HOW GOOD THEY FEEL</p>
                </div>
                <div class="slogan">
                    <h1>Sneakers</h1>
                    <p>SEE HOW GOOD THEY FEEL</p>
                </div>
                <div class="slogan">
                    <h1>Adidas</h1>
                    <p>SEE HOW GOOD THEY FEEL</p>
                </div>

                <div class="media-icons">
                    <i class='bx bxl-facebook'></i>
                    <i class='bx bxl-instagram-alt'></i>
                    <i class='bx bxl-twitter'></i>
                    <i class='bx bxl-google'></i>
                </div>

                <div class="slider-navigation">
                    <div class="nav-btn active"></div>
                    <div class="nav-btn"></div>
                    <div class="nav-btn"></div>
                    <div class="nav-btn"></div>
                    <div class="nav-btn"></div>
                    <div class="nav-btn"></div>
                </div>
            </div>

            <div class="space">

            </div>
            <!-- body -->
            <div class="body__downshifter">
                <div class="body__downshifter-first">
                    <img src="./image/nike-downshifter.jpg" alt="">
                </div>
                <div class="body__downshifter-second">
                    <div class="body__downshifter-second-describe">
                        <h1>Nike DOWNSHIFTER</h1>
                        <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias consequatur.
                            sed quia non numquam eius modi tempora incidunt ut labore et dolore
                        </p>
                        <button>
                            <a href="/shop-now?bID=101010">Shop Now</a>
                        </button>
                    </div>
                    <div class="body__downshifter-second-img">
                        <img src="./image/nike.jpg" alt="">
                        <h2>Air Force</h2>
                    </div>
                </div>
            </div>

            <!-- space -->
            <div class="space">

            </div>

            <div class="body__sneaker">
                <div class="body__sneaker-item">
                    <div class="body__sneaker-item__describe">
                        <h1>Sneaker</h1>
                        <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias consequatur.
                            sed quia non numquam eius modi tempora incidunt ut labore et dolore
                        </p>
                        <button>
                            <a href="/shop-now?bID=101010">Shop Now</a>
                        </button>
                    </div>
                    <div class="body__sneaker-item__img">
                        <img src="./image/vans.png" alt="">
                        <h2>Vans</h2>
                    </div>
                </div>
                <div class="body__sneaker-item">
                    <div class="body__sneaker-item">
                        <div class="body__sneaker-item__img">
                            <img src="./image/sneaker.png" alt="">
                            <h2>Sneaker</h2>
                        </div>
                        <div class="body__sneaker-item__describe-black">
                            <h1>Vans</h1>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias consequatur.
                                sed quia non numquam eius modi tempora incidunt ut labore et dolore
                            </p>
                            <button>
                                <a href="/shop-now?bID=101010">Shop Now</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- login -->
            <c:if test="${empty auth}">
            <div class="login">
                <form action="user-login" method="post">
                    <h1>Login for Fashion Feet !</h1>
                    <div class="login__item">
                        <div class="login__input">
                            <input type="email" name="user-email" placeholder="Enter your email ..." required>
                            <input type="password" name="user-password" placeholder="Enter your Password ..." required>
                        </div>
                        <div class="login__submit">
                            <button type="submit">LOGIN</button>
                            <span></span>
                        </div>
                    </div>
                </form>
            </div>
            </c:if>

            <!-- trusted partners -->
            <div class="trusted-partners">
                <div class="trusted-partners__title">
                    <h3>TRUSTED PARTNERS</h3>
                </div>
                <div class="trusted-partners__img">
                    <div class="trusted-partners__img-item">
                        <img src="./image/brand-1.jpg" alt="">
                    </div>
                    <div class="trusted-partners__img-item">
                        <img src="./image/brand-2.jpg" alt="">
                    </div>
                    <div class="trusted-partners__img-item">
                        <img src="./image/brand-3.jpg" alt="">
                    </div>
                    <div class="trusted-partners__img-item">
                        <img src="./image/brand-4.jpg" alt="">
                    </div>
                    <div class="trusted-partners__img-item">
                        <img src="./image/brand-5.jpg" alt="">
                    </div>
                </div>
            </div>

            <%@include file="includes/footer.jsp" %>
        </div>

        <script src="js/navbar.js"></script>
        <script src="js/home.js"></script>

    </body>

</html>

<%@page import="com.model.User"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.dao.InformationDao"%>
<%@page import="com.model.Information"%>

<jsp:useBean id="i" class="com.dao.InformationDao" scope="request"></jsp:useBean>

<!-- footer -->
<div class="footer">
    <!-- follow -->
    <div class="footer__follow">
        <div class="footer__information-title">
            <h2>Fashion</h2>
            <h2>Feet</h2>
        </div>
        <p>
            We are glad to welcome you in our store. You have made a right choice and we are going to prove that
            our goods are the best.
            You will be very surprised by the variety of our huge assortment.
        </p>
        <div class="follow__icon">
            <div class="follow__icon-fb">
                <i class='bx bxl-facebook'></i>
                <span></span>
            </div>

            <div class="follow__icon-ins">
                <i class='bx bxl-instagram-alt'></i>
                <span></span>
            </div>

            <div class="follow__icon-twit">
                <i class='bx bxl-twitter'></i>
                <span></span>
            </div>

            <div class="follow__icon-gg">
                <i class='bx bxl-google'></i>
                <span></span>
            </div>
        </div>
    </div>

    <!-- About -->
    <div class="footer__about">
        <div class="footer__information-title">
            <h2>Our</h2>
            <h2>Information</h2>
        </div>
        <ul class="footer__about-items">
            <li>Home</li>
            <li>About us</li>
            <li>Contact</li>
            <li>Help</li>
        </ul>
    </div>

    <!-- Information -->
    <div class="footer__information">
        <div class="footer__information-title">
            <h2>Store</h2>
            <h2>Information</h2>
        </div>

        <!-- Phone -->
        <div class="footer__information-item">
            <div class="footer__information-item-icon">
                <i class="fa-solid fa-phone"></i>
            </div>
            <div class="footer__information-item-infor">
                <p>Phone Number</p>
                <p>${i.getinfor().phone}</p>
            </div>
        </div>

        <!-- Email -->
        <div class="footer__information-item">
            <div class="footer__information-item-icon">
                <i class="fa-solid fa-envelope"></i>
            </div>
            <div class="footer__information-item-infor">
                <p>Email</p>
                <p>Email: <a href="">${i.getinfor().email}</a></p>
            </div>
        </div>

        <!-- Location -->
        <div class="footer__information-item">
            <div class="footer__information-item-icon">
                <i class="fa-solid fa-location-dot"></i>
            </div>
            <div class="footer__information-item-infor">
                <p>Location</p>
                <p>${i.getinfor().address}</p>
            </div>
        </div>
    </div>

</div>

<!-- design -->
<div class="design">
    <p>
        2022 Fashion Feet. All rights reverse | Design by
        <a href="">Group 11</a>
    </p>
</div>
<!-- scroll -->
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script>
    $(document).ready(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop()) {
                $(".header").addClass("sticky");
            } else {
                $(".header").removeClass("sticky");
            }
        })
    })
</script>
<%-- 
    Document   : contact
    Created on : Nov 26, 2022, 3:21:52 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/header.jsp" %>
        <title>Contact Us</title>
    </head>
    <body>
        <div class="contact">
            <%@include file="includes/navbar.jsp" %>

            <!-- bg-top -->
            <div class="bg-img-top">
            </div>

            <!-- body -->
            <div class="contact__title">
                <h1>Contact us</h1>
                <p>Add some description</p>
            </div>

            <div class="contact__content">
                <div class="contact__content-form">
                    <p>Please fill this form to contact with us</p>
                    <form action="" class="contact-form">
                        <div class="input">
                            <div class="input-item">
                                <p>User name</p>
                                <input type="text" />
                            </div>
                            <div class="input-item">
                                <p>Telephone</p>
                                <input type="number" />
                            </div>
                        </div>
                        <div class="input">
                            <div class="input-item">
                                <p>Email</p>
                                <input type="email" />
                            </div>
                            <div class="input-item">
                                <p>Subject</p>
                                <input type="text" />
                            </div>
                        </div>
                        <textarea name="" id="" cols="30" rows="10" placeholder="Message..."> </textarea>
                        <div class="form__action">
                            <button type="submit">Submit</button>
                            <button type="reset">Clear</button>
                        </div>
                    </form>
                </div>

                <div class="contact__content-info">
                    <p>Contact Information</p>
                    <div class="info-item">
                        <div class="info-item__icon">
                            <i class="fa-solid fa-house-chimney"></i>
                            <span></span>
                        </div>
                        <div class="info-describe">
                            <h4>Visit us</h4>
                            <p>Vo Van Ngan, Thu Duc District, Ho Chi Minh City</p>
                        </div>
                    </div>
                    <div class="info-item">
                        <div class="info-item__icon">
                            <i class="fa-solid fa-envelope"></i>
                            <span></span>
                        </div>
                        <div class="info-describe">
                            <h4>Mail us</h4>
                            <p>19110091@student.hcmute.edu.vn</p>
                        </div>
                    </div>
                    <div class="info-item">
                        <div class="info-item__icon">
                            <i class="fa-solid fa-phone"></i>
                            <span></span>
                        </div>
                        <div class="info-describe">
                            <h4>Call us</h4>
                            <p>0888346324</p>
                        </div>
                    </div>
                    <div class="info-item">
                        <div class="info-item__icon">
                            <i class="fa-solid fa-fax"></i>
                            <span></span>
                        </div>
                        <div class="info-describe">
                            <h4>Fax</h4>
                            <p>0888346324</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="contact__map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.4841606803075!2d106.76240491477206!3d10.850732092271128!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527bd7417401d%3A0xe87fb2433d012c99!2zxJAuIFbDtSBWxINuIE5nw6JuLCBUaOG7pyDEkOG7qWMsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1666001271988!5m2!1svi!2s" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <%@include file="includes/footer.jsp" %>
        </div>
        <script src="js/navbar.js"></script>
    </body>
</html>

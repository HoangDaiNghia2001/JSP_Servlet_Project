/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.model.Cart;
import com.model.ProductCart;
import com.model.User;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/send-email-bill")
public class SendEmailBillServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phone = (String) req.getSession().getAttribute("phone");
        String address = (String) req.getSession().getAttribute("address");

        User auth = (User)req.getSession().getAttribute("auth");
        
        String email = String.valueOf(req.getSession().getAttribute("emailUser"));

        String txt = "";

        Cart cart = (Cart) req.getSession().getAttribute("bill");

        for (ProductCart c : cart.getLstitems()) {
            txt +=" + " + c.getProduct().getProductName() + " | Số lượng: " + c.getQuantity() + " | Size: " + c.getSize() + " | Tiền cho 1 sản phẩm: $" + c.getProduct().getProductPrice() + "\r\n";
        }

        if (email != null || !email.equals("")) {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("bebebechecheche@gmail.com", "dgrrxrbdhtmqhpoz");
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                message.setSubject("ĐẶT HÀNG THÀNH CÔNG","UTF-8");
                message.setText("Dear: " + auth.getUserName() + "\r\n"
                        + "Bạn đã đặt hàng thành công từ Fashion Feet." + "\r\n"
                        + "Số điện thoại để nhận hàng là: " + phone + "\r\n"
                        + "Địa chỉ nhận hàng của bạn là: " + address + "\r\n"
                        + "Danh sách sản phẩm bạn đã đặt là: " +"\r\n"
                        + txt + "\r\n"
                        + "Tổng tiền: $" + cart.getTotalMoney() + "\r\n"
                        + "CẢM ƠN BẠN ĐÃ LỰA CHỌN FASHION FEET. ĐƯỢC PHỤC VỤ BẠN LÀ NIỀM VINH HẠNH CỦA CHÚNG TÔI." + "\r\n"
                        + "Fashion Feet." ,"UTF-8");
                // // send message
                Transport.send(message);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("/shop-now?bID=101010");
        }

    }

}

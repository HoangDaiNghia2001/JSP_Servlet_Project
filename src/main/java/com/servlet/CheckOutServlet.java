/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.model.Cart;
import com.model.Product;
import com.model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao oDao = new OrderDao();
        ProductDao pDao = new ProductDao();

        try {

            String phone = (String) req.getSession().getAttribute("phone");
            String address = (String) req.getSession().getAttribute("address");

            List<Product> lstAllProduct = pDao.getAllProducts();

            Cookie[] arr = req.getCookies();

            String txt = "";
            String amountProCart = "";

            for (Cookie c : arr) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();

                }
                if (c.getName().equals("amountProductCart")) {
                    amountProCart += c.getValue();

                }
            }

            if (txt.equals("")) {
                req.getRequestDispatcher("/shop-now?bID=101010").forward(req, resp);
            } else {
                if (phone == null && address == null) {
                    req.getSession().setAttribute("infor", "none");
                    req.getRequestDispatcher("/cart-list").forward(req, resp);
                } else {
                    Cart cart = new Cart(txt, lstAllProduct);

                    req.getSession().setAttribute("bill", cart); // hoa don

                    User user = (User) req.getSession().getAttribute("auth");

                    String number = String.valueOf(req.getSession().getAttribute("phone"));
                    String addressInfor = String.valueOf(req.getSession().getAttribute("address"));

                    oDao.addOrder(user, cart, number, addressInfor);

                    int orderID = oDao.getOrderID();

                    oDao.createOderLine(cart, orderID);
                    oDao.updateAmountPro(cart);

                    Cookie c = new Cookie("cart", "");
                    c.setMaxAge(0);
                    resp.addCookie(c);

                    Cookie d = new Cookie("amountProductCart", "");
                    d.setMaxAge(0);
                    resp.addCookie(d);

                    req.getSession().setAttribute("amount", 0);

                    resp.sendRedirect("/thanks-for-your-support");
                }
            }
        } catch (Exception e) {
        }
    }
}

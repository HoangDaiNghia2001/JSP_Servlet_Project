/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.ProductDao;
import com.model.Cart;
import com.model.Product;
import com.model.ProductCart;
import com.model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = null;

        User auth = (User) req.getSession().getAttribute("auth");

        if (auth == null) {
            dispatcher = req.getRequestDispatcher("/user-login");
        } else {
            ProductDao pDao = new ProductDao();
            List<Product> lstAllProducts = pDao.getAllProducts();

            Cookie[] arr = req.getCookies();

            String txt = "";

            if (arr != null) {
                for (Cookie c : arr) {
                    if (c.getName().equals("cart")) {
                        txt += c.getValue();
                        c.setMaxAge(0);
                        resp.addCookie(c);
                    }
                    if(c.getName().equals("amountProductCart"))
                    {
                        c.setMaxAge(0);
                        resp.addCookie(c);
                    }
                }
            }

            String size = req.getParameter("size");
            String quantity = req.getParameter("quantity");
            String id = req.getParameter("proID");

            if (txt.isEmpty()) {
                txt = id + "_" + quantity + "_" +size;
            } else {
                txt = txt + "/" + id + "_" + quantity + "_" +size;
            }

            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(c);

            Cart cart = new Cart(txt, lstAllProducts);

            List<ProductCart> lstCarts = cart.getLstitems();

            int amountProCart = 0;

            if (lstCarts != null) {
                amountProCart = lstCarts.size();
            } else {
                amountProCart = 0;
            }

            String amountString = String.valueOf(amountProCart);
            Cookie aCookie = new Cookie("amountProductCart", amountString);
            aCookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(aCookie);

            req.getSession().setAttribute("amount", amountProCart);
            
            dispatcher = req.getRequestDispatcher("ShopNow.jsp");
        }
        dispatcher.forward(req, resp);
    }

}

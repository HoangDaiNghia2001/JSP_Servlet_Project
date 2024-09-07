/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.ProductDao;
import com.model.Cart;
import com.model.Product;
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
@WebServlet("/cart-list")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = null;

        try {
            ProductDao pDao = new ProductDao();
            List<Product> lstAllProducts = pDao.getAllProducts();

            Cookie[] arr = req.getCookies();

            String txt = "";

            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txt = o.getValue();
                    }
                }
            }

            Cart cart = new Cart(txt, lstAllProducts);

            req.setAttribute("cart", cart);

            String amountProCart = "";

            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("amountProductCart")) {
                        amountProCart = o.getValue();
                    }
                }
            }

            req.setAttribute("amount", amountProCart);
            

            dispatcher = req.getRequestDispatcher("Cart.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
        }
    }

}

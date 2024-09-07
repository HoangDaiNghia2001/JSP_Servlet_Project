/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.ProductDao;
import com.model.Cart;
import com.model.Product;
import com.model.ProductCart;
import java.io.IOException;
import java.util.*;
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
@WebServlet("/quantity")
public class QuantityIncreDecre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ProductDao pDao = new ProductDao();
        List<Product> lstAllProducts = pDao.getAllProducts();

        Cookie[] arr = req.getCookies();

        String txt = "";

        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt = o.getValue();
                    o.setMaxAge(0);
                    resp.addCookie(o);
                }
            }
        }

        Cart cart = new Cart(txt, lstAllProducts);

        String action = req.getParameter("num");
        String proID = req.getParameter("pID");
        String s = req.getParameter("size");
        
        int pID, num,size = 0;

        try {

            pID = Integer.parseInt(proID);
            Product p = pDao.getProductByID(proID);
            
            int amountPro = p.getProductAmout();

            num = Integer.parseInt(action);
            size= Integer.parseInt(s);
            
            if ((num == -1) && (cart.getQuantityByIDAndBySize(pID,size)) <= 1) {
                cart.removeProductCart(pID,size);
            } else {
                if (num == 1 && cart.getQuantityByID(pID) >= amountPro) {
                    num = 0;
                }

                ProductCart pCart = new ProductCart(num, p,size);
                cart.addProductCart(pCart,size);
            }

        } catch (NumberFormatException e) {

        }

        List<ProductCart> lstPro = cart.getLstitems();

        txt = "";
        if (lstPro.size() > 0) {
            txt = lstPro.get(0).getProduct().getProductID() + "_" + lstPro.get(0).getQuantity() + "_" + lstPro.get(0).getSize();
            for (int i = 1; i < lstPro.size(); i++) {
                txt += "/" + lstPro.get(i).getProduct().getProductID() + "_" + lstPro.get(i).getQuantity()+ "_" + lstPro.get(i).getSize();
            }
        }

        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(c);

        int amountProCart = 0;

        if (lstPro != null) {
            amountProCart = lstPro.size();
        } else {
            amountProCart = 0;
        }

        String amountString = String.valueOf(amountProCart);
        Cookie aCookie = new Cookie("amountProductCart", amountString);
        aCookie.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(aCookie);

        req.getSession().setAttribute("amount", amountProCart);

        req.setAttribute("cart", cart);
        req.getRequestDispatcher("Cart.jsp").forward(req, resp);

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.model.Cart;
import com.model.Product;
import com.model.ProductCart;
import com.model.User;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/buy-now")
public class BuyNowServlet extends HttpServlet {
    
    OrderDao oDao = new OrderDao();
    ProductDao pDao = new ProductDao();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = (String) req.getSession().getAttribute("phone");
        String address = (String) req.getSession().getAttribute("address");
        
        if (phone == null && address == null) {
            req.getSession().setAttribute("infor", "none");
            req.getRequestDispatcher("Cart.jsp").forward(req, resp);
        } else {
            
            String productID = String.valueOf(req.getParameter("productID"));
            String productSize = String.valueOf(req.getParameter("sizeItems"));
            String quantityProCart = String.valueOf(req.getParameter("quantityItems"));
            String productPrice = String.valueOf(req.getParameter("productPrice"));
            String productName = String.valueOf(req.getParameter("productName"));
            
            int pId = Integer.parseInt(productID);
            double pPrice = Double.parseDouble(productPrice);
            int quantity = Integer.parseInt(quantityProCart);
            int size = Integer.parseInt(productSize);
            Product p = new Product(pId, productName, pPrice);
            
            ProductCart pCart = new ProductCart(quantity, p, size);
            
            List<ProductCart> lstProCart = new ArrayList<ProductCart>();
            lstProCart.add(pCart);
            
            Cart cart = new Cart(lstProCart);
            
            req.getSession().setAttribute("bill", cart); // hoa don

            User user = (User) req.getSession().getAttribute("auth");
            
            String number = String.valueOf(req.getSession().getAttribute("phone"));
            String addressInfor = String.valueOf(req.getSession().getAttribute("address"));
            
            oDao.addOrder(user, cart, number, addressInfor);
            
            int orderID = oDao.getOrderID();
            
            oDao.createOderLine(cart, orderID);
            oDao.updateAmountPro(cart);

            // xoa di san pham vua mua trong gio hang
            List<Product> lstAllProduct = pDao.getAllProducts();
            
            Cookie[] arr = req.getCookies();
            
            String txt = "";
            for (Cookie c : arr) {
                if (c.getName().equals("cart")) {
                    txt = c.getValue();
                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
            }
            
            String[] items = txt.split("/");
            String out = "";
            
            for (int i = 0; i < items.length; i++) {
                String[] s = items[i].split("_");
                
                if ((!s[0].equals(productID)) || (s[0].equals(productSize) && !s[2].equals(size))) {
                    if (out.isEmpty()) {
                        out = items[i];
                    } else {
                        out += "/" + items[i];
                    }
                }
            }
            
            if (!out.isEmpty()) {
                Cookie c = new Cookie("cart", out);
                c.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(c);
            }
            
            Cart c = new Cart(out, lstAllProduct);
            
            List<ProductCart> lstPro = c.getLstitems();
            
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
            
            req.setAttribute("cart", c);

            resp.sendRedirect("/thanks-for-your-support");          
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/buy-now").forward(req, resp);
    }
    
}

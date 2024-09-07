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
@WebServlet("/remove-pro-cart")
public class RemoveProductCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ProductDao pDao = new ProductDao();

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

        String pID = req.getParameter("pID");
        String size = req.getParameter("size");
        
        String [] items = txt.split("/");
        String out = "";
        
        for(int i=0; i< items.length; i++)
        {
            String []s = items[i].split("_");
            
            if((!s[0].equals(pID)) || (s[0].equals(pID) && !s[2].equals(size)))
            {
                if(out.isEmpty())
                {
                    out = items[i];
                }
                else{
                    out += "/" + items[i];
                }
            }
        }
        
        if(!out.isEmpty())
        {
            Cookie c = new Cookie("cart", out);
            c.setMaxAge(60*60*24*7);
            resp.addCookie(c);
        }
        
        Cart cart = new Cart(out, lstAllProduct);
        
        List<ProductCart> lstPro = cart.getLstitems();
        
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
        
        //set lai gia tri de k hien form dien thong tin khi xoa san pham khoi gio hang
        req.getSession().setAttribute("infor", "");
        
        req.getRequestDispatcher("Cart.jsp").forward(req, resp);
    }

}

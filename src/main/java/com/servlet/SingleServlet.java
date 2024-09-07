/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.BrandDao;
import com.dao.ProductDao;
import com.model.Brand;
import com.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/single-page")
public class SingleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = null;

        try ( PrintWriter out = resp.getWriter()) {

            getProductByID(req, resp);
            get4Product(req, resp);
            getBrandByIdProduct(req, resp);            
            
            //lay ra so luong san pham trong gio hang
            Cookie[] arr = req.getCookies();

            String amountProCart = "";

            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("amountProductCart")) {
                        amountProCart = o.getValue();
                    }
                }
            }

            req.getSession().setAttribute("amount", amountProCart);
            //
                       
            dispatcher = req.getRequestDispatcher("single.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
        }

    }

    protected void getProductByID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao pDao = new ProductDao();

        String pID = req.getParameter("pID");
        if (!pID.equals("")) {
            Product p = pDao.getProductByID(pID);
            req.getSession().setAttribute("product", p);
        }
    }

    protected void get4Product(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao pDao = new ProductDao();

        List<Product> lst4Product = pDao.get4Products();
        req.getSession().setAttribute("lst4Product", lst4Product);
    }

    protected void getBrandByIdProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandDao bDao = new BrandDao();

        String bID = req.getParameter("brandID");

        Brand b = bDao.getBrandByIdProduct(bID);
        req.getSession().setAttribute("brand", b);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.ProductDao;
import com.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/admin-search-product")
public class SearchProductByAdminServlet extends HttpServlet {

    ProductDao pDao = new ProductDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        try {
            String id = req.getParameter("productID");
            Product p = pDao.getProductByID(id);
            List<Product> lstPro = new ArrayList<Product>();

            if (p != null) {
                lstPro.add(p);
            }

            req.getSession().setAttribute("lstProPageAdmin", lstPro);

            req.getSession().setAttribute("productId", id);
            req.getSession().removeAttribute("clicked");

            req.getRequestDispatcher("PageAdmin.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

}

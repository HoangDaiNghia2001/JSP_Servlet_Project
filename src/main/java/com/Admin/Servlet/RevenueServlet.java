/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.RevenueDao;
import com.model.OrderDetail;
import java.io.IOException;
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
@WebServlet("/admin-revenue-of-fashion-feet")
public class RevenueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        RevenueDao oDao = new RevenueDao();

        List<OrderDetail> lstRevenue = oDao.getOrderDetail();
        double price = oDao.getTotalPrice();
        
        for (OrderDetail o : lstRevenue) {
            o.setpAmount(oDao.getAmountProductById(o.getpID()));
            o.setpPrice(oDao.getPriceProductById(o.getpID()));
        }

        req.getSession().removeAttribute("productId");
        req.getSession().setAttribute("lstRevenue", lstRevenue);
                req.getSession().setAttribute("totalPrice", price);
        req.getSession().setAttribute("clicked", "revenue-admin");

        req.getRequestDispatcher("revenue.jsp").forward(req, resp);
    }

}

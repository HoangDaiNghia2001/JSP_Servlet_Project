/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/delete-product")
public class DeleteProductWithChkServlet extends HttpServlet {

    ProductDao pDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        try ( PrintWriter out = resp.getWriter()) {
            String arr = req.getParameter("checked");
            String[] arrID = arr.split(",");
            for (String id : arrID) {
                pDao.RemoveProduct(id);
            }
            String index = String.valueOf(req.getSession().getAttribute("flag"));
            String url = "/admin-manager-product?pIndex=" + index;
            req.getRequestDispatcher(url).forward(req, resp);
        } catch (Exception e) {
        }
    }

}

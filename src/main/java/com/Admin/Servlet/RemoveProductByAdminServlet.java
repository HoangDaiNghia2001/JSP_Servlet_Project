/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.ProductDao;
import com.sun.javafx.scene.text.TextLayout;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/admin-remove-product")
public class RemoveProductByAdminServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("proId");
        ProductDao pDao = new ProductDao();
        pDao.RemoveProduct(id);
        
        String index = String.valueOf(req.getSession().getAttribute("flag"));
        String url = "/admin-manager-product?pIndex=" + index;
        
        req.getRequestDispatcher(url).forward(req, resp);
    }
    
}

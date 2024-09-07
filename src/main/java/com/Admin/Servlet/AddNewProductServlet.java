/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.ProductDao;
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
@WebServlet("/add-new-product")
public class AddNewProductServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        
        try {
            String pName = req.getParameter("pro-name");
            String pDescrip = req.getParameter("pro-descrip");
            String pPrice = req.getParameter("pro-price");
            String pImgLink = req.getParameter("pro-link");
            String pCategoryID = req.getParameter("pro-cateID");
            String pAmount = req.getParameter("pro-amount");
            
            double dPrice = Double.parseDouble(pPrice);
            int iCateID = Integer.parseInt(pCategoryID);
            int iAmount = Integer.parseInt(pAmount);
            
            ProductDao pDAO = new ProductDao();
            boolean rs = pDAO.AddProduct(pName, pDescrip, dPrice, pImgLink, iCateID, iAmount);
            if (rs) {
                String index = String.valueOf(req.getSession().getAttribute("amountPage"));
                String url = "/admin-manager-product?pIndex=" + index;
                
                resp.sendRedirect(url);
                
            }
        } catch (Exception e) {
        }
    }
}

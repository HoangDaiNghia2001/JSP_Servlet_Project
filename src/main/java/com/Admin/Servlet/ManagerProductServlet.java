/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.BrandDao;
import com.dao.ProductDao;
import com.model.Brand;
import com.model.Product;
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
@WebServlet("/admin-manager-product")
public class ManagerProductServlet extends HttpServlet {

    ProductDao pDao = new ProductDao();
    BrandDao bDao = new BrandDao();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        try {
            
            loadProduct(req, resp);
            loadBrandAndAmountPro(req, resp);
            countAllAmountPro(req, resp);
            
            req.getSession().removeAttribute("productId");
            req.getSession().setAttribute("clicked", "manage-pro");
            req.getRequestDispatcher("PageAdmin.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

    protected void loadProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageIndex = req.getParameter("pIndex");
        
        int amoutPage = pDao.amountProduct()/7;
        
        if(pDao.amountProduct() % 7 != 0)
        {
            amoutPage++;
        }
        
        if(pageIndex == null)
        {
            pageIndex ="1";
        }
        
        int index = Integer.parseInt(pageIndex);
        
        List<Product> lstPro = pDao.loadProductPageAdmin(index);
        req.getSession().setAttribute("lstProPageAdmin", lstPro);
        req.getSession().setAttribute("flag", index);
        req.getSession().setAttribute("amountPage", amoutPage);
    }
    
     protected void loadBrandAndAmountPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Brand> lstBrand = bDao.getBrand();
         for (Brand b : lstBrand) {
             String id = String.valueOf(b.getBrandID());
             int amount = bDao.getAmountProductOfBrand(id);
             b.setAmountProduct(amount);
         }
         req.getSession().setAttribute("lstBrand", lstBrand);
     }
     
     protected void countAllAmountPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int amount = pDao.amountProduct();
         
         req.getSession().setAttribute("countAllPro", amount);
     }

}

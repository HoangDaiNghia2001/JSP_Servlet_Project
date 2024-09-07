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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/search-product")
public class SearchProductServlet extends HttpServlet {

    ProductDao pDao = new ProductDao();
    BrandDao bDao = new BrandDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = null;
        try ( PrintWriter out = resp.getWriter()) {
//            getListBrands(req, resp);
//            getLastProduct(req, resp);
            get6ProductsBySearch(req, resp);

            dispatcher = req.getRequestDispatcher("ShopNow.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
        }
    }

    protected void get6ProductsBySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("product_name");
        String min = req.getParameter("min");
        String max = req.getParameter("max");

        Double mMin = Double.parseDouble(min);
        Double mMax = Double.parseDouble(max);

        List<Product> lstProducts = pDao.get6ProductBySeacrh(name, mMin, mMax);

        req.getSession().setAttribute("lstProduct", lstProducts);
        req.getSession().setAttribute("check", "search");
        req.getSession().setAttribute("priceMin", mMin);
        req.getSession().setAttribute("priceMax", mMax);
        req.getSession().setAttribute("search", name);
    }

//    protected void getListBrands(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        List<Brand> lstBrand = bDao.getBrand();
//
//        for (Brand brand : lstBrand) {
//            String bID = String.valueOf(brand.getBrandID());
//            int amount = bDao.getAmountProductOfBrand(bID);
//            brand.setAmountProduct(amount);
//        }
//
//        req.getSession().setAttribute("lstBrand", lstBrand);
//    }
//
//    protected void getLastProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Product product = pDao.getLastProduct();
//        req.getSession().setAttribute("lastProduct", product);
//    }
}

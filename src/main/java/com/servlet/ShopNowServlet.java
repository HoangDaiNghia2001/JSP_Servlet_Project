/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.BrandDao;
import com.dao.ProductDao;
import com.dao.ViewDao;
import com.model.Brand;
import com.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
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
@WebServlet("/shop-now")
public class ShopNowServlet extends HttpServlet {

    BrandDao bDao = new BrandDao();
    ProductDao pDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = null;
        try ( PrintWriter out = resp.getWriter()) {

            //load san pham
            getListBrands(req, resp);
            getListProducts(req, resp);
            getLastProduct(req, resp);

            //lay ra tong so san pham
            int count = pDao.amountProduct();
            req.getSession().setAttribute("countAllPro", count);

            // lay ra gia tien dat nhat
            int maxPrice = pDao.getMaxPrice();
            req.getSession().setAttribute("max", maxPrice);

            // lay ra gia tien re nhat
            int minPrice = pDao.getMinPrice();
            req.getSession().setAttribute("min", minPrice);

            // khoi tao gia tien can tim kiem ban dau
            req.getSession().setAttribute("priceMin", minPrice);
            req.getSession().setAttribute("priceMax", maxPrice);

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

            req.getSession().setAttribute("search", "");
            req.getSession().setAttribute("check", "");

            dispatcher = req.getRequestDispatcher("ShopNow.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void getListBrands(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Brand> lstBrand = bDao.getBrand();

        for (Brand brand : lstBrand) {
            String bID = String.valueOf(brand.getBrandID());
            int amount = bDao.getAmountProductOfBrand(bID);
            brand.setAmountProduct(amount);
        }

        req.getSession().setAttribute("lstBrand", lstBrand);
    }

    protected void getListProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brandID = req.getParameter("bID");

        if (brandID.equals("101010")) {
            loadProductOfPage(req, resp);
        } else {
            loadProductOfPageByBrand(req, resp);
        }

        List<Product> lst5Products = pDao.getTop5Products();
        req.getSession().setAttribute("lst5Product", lst5Products);

    }

    protected void getLastProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = pDao.getLastProduct();
        req.getSession().setAttribute("lastProduct", product);

    }

    protected void loadProductOfPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageIndex = req.getParameter("pageIndex");

        int amoutProduct = pDao.amountProduct();
        int endPage = amoutProduct / 9;

        if (pageIndex == null) {
            pageIndex = "1";
        }

        int index = Integer.parseInt(pageIndex);

        if (amoutProduct % 9 != 0) {
            endPage++;
        }
        List<Product> lstProducts = pDao.loadProductPage(index);

        req.getSession().setAttribute("tag", index);
        req.getSession().setAttribute("brandID", "101010");
        req.getSession().setAttribute("endPage", endPage);
        req.getSession().setAttribute("lstProduct", lstProducts);

    }

    protected void loadProductOfPageByBrand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brandID = req.getParameter("bID");
        int flag = Integer.parseInt(brandID);

        String pageIndex = req.getParameter("pageIndex");

        int amoutProduct = bDao.getAmountProductOfBrand(brandID);
        int endPage = amoutProduct / 9;

        if (pageIndex == null) {
            pageIndex = "1";
        }

        int index = Integer.parseInt(pageIndex);

        if (amoutProduct % 9 != 0) {
            endPage++;
        }
        List<Product> lstProducts = pDao.loadProductPageByBrand(brandID, index);

        req.getSession().setAttribute("brandID", flag);
        req.getSession().setAttribute("tag", index);
        req.getSession().setAttribute("endPage", endPage);
        req.getSession().setAttribute("lstProduct", lstProducts);

    }
}

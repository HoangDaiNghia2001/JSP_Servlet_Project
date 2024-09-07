/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.ProductDao;
import com.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/range-price")
public class FindProductByPriceJavaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ProductDao pDao = new ProductDao();

        try ( PrintWriter out = resp.getWriter()) {

            String min = req.getParameter("priceMin");
            String max = req.getParameter("priceMax");

            double dMin = Double.parseDouble(min);
            double dMax = Double.parseDouble(max);
            String name = String.valueOf(req.getSession().getAttribute("search"));
            
            List<Product> lstProduct = pDao.get6ProductBySeacrh(name,dMin,dMax);
            

            for (Product p : lstProduct) {
                out.println("<div class=\"product list-product__item\">                                                                                   \n"
                        + "                                <div class=\"list-product__item-img\">\n"
                        + "                                    <button class=\"quick-view\"><a href=\"/single-page?pID=" + p.getProductID() + "&brandID=" + p.getcID() + "\">Quick view</a></button>\n"
                        + "                                    <img src=\"./image/" + p.getImageLink() + "\" alt=\"\" />\n"
                        + "                                </div>\n"
                        + "                                <div class=\"product-name\">\n"
                        + "                                    <h3>" + p.getProductName() + "</h3>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"list-product__item__buy\">\n"
                        + "                                    <div class=\"list-product__item__buy-price\">\n"
                        + "                                        <h5>$ " + p.getProductPrice() + "</h5>\n"
                        + "                                        <div class=\"list-product__item__buy-price__start\">\n"
                        + "                                            <i class=\"fa-solid fa-star\"></i>\n"
                        + "                                            <i class=\"fa-solid fa-star\"></i>\n"
                        + "                                            <i class=\"fa-solid fa-star\"></i>\n"
                        + "                                            <i class=\"fa-solid fa-star\"></i>\n"
                        + "                                            <i class=\"fa-solid fa-star\"></i>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div class=\"list-product__item__buy-cart\">\n"
                        + "                                        <a href=\"/add-to-cart?pID=" + p.getProductID() + "\"><i class=\"fa-solid fa-cart-shopping\"></i></a>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>");
            }
        } catch (Exception e) {
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.UserDao;
import com.model.User;
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
@WebServlet("/admin-change-infor-admin")
public class ChangeInforAdmin extends HttpServlet {

    UserDao uDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {

            // xoa thong tin admin chi du lai id cua admin
            String aId = req.getParameter("ad-id");
            int id = Integer.parseInt(aId);
            uDao.deleteInforOffAdmin(aId);

//            // Them lai thong tin
            String aName = req.getParameter("ad-name");
            String aEmail = req.getParameter("ad-email");
            String aPass = req.getParameter("ad-pass");
            String aRepeat = req.getParameter("ad-repeat");
            String aIsAdmin = req.getParameter("ad-isAdmin");
            int admin = Integer.parseInt(aIsAdmin);

            if (uDao.getUserEmail(aEmail)) {
                req.setAttribute("notify", "email existed");

                req.getRequestDispatcher("ChangeInforAdmin.jsp").forward(req, resp);
            } else {
                if (!aPass.equals(aRepeat)) {
                    req.setAttribute("notify", "not matched");

                    req.getSession().setAttribute("valueEmail", aEmail);
                    req.getSession().setAttribute("valueName", aName);

                    req.getRequestDispatcher("ChangeInforAdmin.jsp").forward(req, resp);
                } else {
                    uDao.changeInforOfAdmin(id, aName, aPass, aEmail, admin);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }

        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.removeAttribute("notify");

        req.getSession().removeAttribute("productId");
        req.getSession().setAttribute("clicked", "change-admin");
        req.getSession().removeAttribute("valueEmail");
        req.getSession().removeAttribute("valueName");

        req.getRequestDispatcher("ChangeInforAdmin.jsp").forward(req, resp);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.Servlet;

import com.dao.UserDao;
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
@WebServlet("/admin-add-new-admin")
public class AddAdminServlet extends HttpServlet {

    UserDao uDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            String aName = req.getParameter("ad-name");
            String aEmail = req.getParameter("ad-email");
            String aPass = req.getParameter("ad-pass");
            String aRepeat = req.getParameter("ad-repeat");

            if (uDao.getUserEmail(aEmail) && (uDao.checkAdminByEmail(aEmail) == 1)) {
                req.setAttribute("notify", "email existed");

                req.getRequestDispatcher("AddNewAdmin.jsp").forward(req, resp);
            } else {
                if (!aPass.equals(aRepeat)) {
                    req.setAttribute("notify", "not matched");

                    req.getSession().setAttribute("valueEmail", aEmail);
                    req.getSession().setAttribute("valueName", aName);

                    req.getRequestDispatcher("AddNewAdmin.jsp").forward(req, resp);
                } else {
                    if (uDao.getUserEmail(aEmail) && uDao.checkAdminByEmail(aEmail) != 1) {
                        uDao.updateAdmin(aName, aPass, aEmail);
                    } else {
                        uDao.AddAdmin(aName, aPass, aEmail);
                    }

                    req.getSession().setAttribute("emailAdmin", aEmail);
                    req.getSession().setAttribute("passAdmin", aPass);
                    req.getSession().setAttribute("nameAdmin", aName);

                    resp.sendRedirect("/send-email-to-admin");
                }
            }

        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.removeAttribute("notify");

        req.getSession().removeAttribute("productId");
        req.getSession().setAttribute("clicked", "add-admin");
        req.getSession().removeAttribute("valueEmail");
        req.getSession().removeAttribute("valueName");

        req.getRequestDispatcher("AddNewAdmin.jsp").forward(req, resp);
    }

}

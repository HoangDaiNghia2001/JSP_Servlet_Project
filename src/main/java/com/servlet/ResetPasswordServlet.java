/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.ResetPassDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newPassword = req.getParameter("password");
        String confPassword = req.getParameter("confPassword");
        String email = String.valueOf(req.getSession().getAttribute("emailForgot"));

        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            ResetPassDao rDao = new ResetPassDao();
            boolean rs = rDao.ResetPass(newPassword, email);
            if (rs) {
                req.setAttribute("status", "resetSuccess");
                resp.sendRedirect("/user-login");
            }
        } else {
            req.setAttribute("status", "resetFailed");
            req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
    }
}

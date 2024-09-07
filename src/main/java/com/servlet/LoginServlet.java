/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.UserDao;
import com.dao.ViewDao;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {

    UserDao uDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        try ( PrintWriter out = resp.getWriter()) {

            String email = req.getParameter("user-email");
            String pass = req.getParameter("user-password");
            String remember = req.getParameter("remember");

            User auth = uDao.userLogin(email, pass);

            if (auth != null) {
                Cookie cUserEmail = new Cookie("cEmail", email);
                Cookie cUserRemember = new Cookie("cRemember", remember);

                if (remember != null) {
                    cUserEmail.setMaxAge(60 * 60 * 24 * 7);
                    cUserRemember.setMaxAge(60 * 60 * 24 * 7);
                } else {
                    cUserEmail.setMaxAge(0);
                    cUserRemember.setMaxAge(0);
                }

                resp.addCookie(cUserEmail);
                resp.addCookie(cUserRemember);

                req.getSession().setAttribute("auth", auth);
                req.getSession().setAttribute("emailUser", email);

                resp.sendRedirect("/shop-now?bID=101010");
            } else {
                if (uDao.getUserEmail(email)) {
                    req.getSession().setAttribute("status", "wrong pass");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else {
                    req.getSession().setAttribute("status", "sigup");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);

    }

}

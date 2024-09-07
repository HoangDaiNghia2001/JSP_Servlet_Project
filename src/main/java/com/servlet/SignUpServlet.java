/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import com.dao.UserDao;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        try ( PrintWriter out = resp.getWriter()) {

            req.getSession().setAttribute("status", "");

            String userName = req.getParameter("user-name-sigup");
            String userEmail = req.getParameter("user-email-sigup");
            String userPass = req.getParameter("user-pass-sigup");
            String userRepeat = req.getParameter("user-repeat-sigup");

            UserDao uDao = new UserDao();

            if (uDao.getUserEmail(userEmail)) {
                req.getSession().setAttribute("status", "email exist");
                resp.sendRedirect("login.jsp");
            } else if (!userPass.equals(userRepeat)) {
                req.getSession().setAttribute("status", "not match");
                resp.sendRedirect("login.jsp");
            }else{
                User user = new User(userName, userPass, userEmail);
                boolean result = uDao.userSignUp(user);
                if(result)
                {
                    req.getSession().setAttribute("status", "success");
                    resp.sendRedirect("login.jsp");
                }
                else{
                    out.println("failed");
                }
            }

        } catch (Exception e) {
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

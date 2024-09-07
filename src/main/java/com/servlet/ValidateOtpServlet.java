/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import java.io.IOException;
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
@WebServlet("/validate-otp")
public class ValidateOtpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = String.valueOf(req.getParameter("otpvalue"));

        String otp = String.valueOf(req.getSession().getAttribute("otp"));

        RequestDispatcher dispatcher = null;

        if (value.equals(otp)) {
            resp.sendRedirect("/reset-password");

        } else {
            req.setAttribute("message", "Wrong OTP");

            dispatcher = req.getRequestDispatcher("ValidateOtp.jsp");
            dispatcher.forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ValidateOtp.jsp").forward(req, resp);
    }
    
}

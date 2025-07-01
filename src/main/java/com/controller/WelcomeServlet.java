package com.controller;

import com.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/welcome") // 映射到 /welcome 路径
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 从 Session 获取用户信息
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;
        if (user != null) {
            request.setAttribute("username", user.getName());
            request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
        } else {
            System.out.println("用户未登录，重定向到登录页");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
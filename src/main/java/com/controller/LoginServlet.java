package com.controller;

import com.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login", "/showLogin"}) // 支持两个路径
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    // doPost 方法保持不变


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 请求：处理登录逻辑
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 简单模拟登录校验（实际应连数据库）
        if ("admin".equals(username) && "123".equals(password)) {
            User user = new User(username); // 创建用户对象
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // 将用户信息存入 Session
            // 登录成功，重定向到欢迎页
            response.sendRedirect(request.getContextPath() + "/welcome");
        } else {
            // 登录失败，回到登录页并提示
            request.setAttribute("errorMsg", "用户名或密码错误！");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
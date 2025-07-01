package com.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/welcome"}) // 拦截 /welcome 请求
public class LoginFilter extends HttpFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化逻辑（如加载配置），当前实验暂无需处理
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // 检查 Session 中是否有用户信息
        if (session != null && session.getAttribute("user") != null) {
            // 已登录，继续执行后续逻辑（放行）
            chain.doFilter(request, response);
        } else {
            // 未登录，重定向到登录页
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {
        // 销毁逻辑（如释放资源），当前实验暂无需处理
    }
}
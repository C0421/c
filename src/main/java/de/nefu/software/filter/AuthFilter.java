package de.nefu.software.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// (修改) 同时保护 /api/news/ 和 /api/comments/ 的非GET请求
		String uri = req.getRequestURI();
		boolean isProtected = uri.startsWith(req.getContextPath() + "/api/news/") ||
				uri.startsWith(req.getContextPath() + "/api/comments/");

		if (isProtected && !req.getMethod().equalsIgnoreCase("GET")) {
			HttpSession session = req.getSession(false);
			if (session == null || session.getAttribute("user") == null) {
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				// ... 返回错误信息 ...
				return;
			}
		}

		chain.doFilter(request, response);
	}
}
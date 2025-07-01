package com.e8.controller;

import com.e8.service.ServiceFactory;
import com.e8.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// 关键修改：更新WebServlet路径
@WebServlet("/e8/getuser")
public class GetUserServlet extends HttpServlet {
	private final UserService userService = ServiceFactory.getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");
		req.setAttribute("user", userService.getUser(id));
		// 关键修改：更新JSP转发路径
		req.getRequestDispatcher("/WEB-INF/jsp/e8/query.jsp")
				.forward(req, resp);
	}
}
package com.e7.controller;

import com.e7.entity.User;
import com.e7.util.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/e7/index")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = new ArrayList<>();
		String sql = "SELECT id, name, insert_time FROM user";

		// 使用 try-with-resources 自动关闭资源
		try (Connection conn = DatabaseUtil.getConnection();
		     PreparedStatement st = conn.prepareStatement(sql);
		     ResultSet rs = st.executeQuery()) {

			while (rs.next()) {
				// 从ResultSet中获取数据并创建User对象
				String id = rs.getString("id");
				String name = rs.getString("name");
				LocalDateTime insertTime = rs.getObject("insert_time", LocalDateTime.class);
				users.add(new User(id, name, insertTime));
			}
		} catch (SQLException e) {
			// 在实际应用中，应记录日志并可能转向一个错误页面
			e.printStackTrace();
			throw new ServletException("Database error retrieving users.", e);
		}

		// 将用户列表存入request作用域
		req.setAttribute("users", users);
		// 转发到JSP页面
		req.getRequestDispatcher("/WEB-INF/jsp/e7/index.jsp").forward(req, resp);
	}
}
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

@WebServlet("/e7/getuser")
public class GetUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = null;
		String userId = req.getParameter("uid");

		String sql = "SELECT id, name, insert_time FROM user WHERE id = ?";

		try (Connection conn = DatabaseUtil.getConnection();
		     PreparedStatement st = conn.prepareStatement(sql)) {

			st.setString(1, userId);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					user = new User();
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setInsertTime(rs.getObject("insert_time", LocalDateTime.class));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Database error getting user details.", e);
		}

		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/jsp/e7/query.jsp").forward(req, resp);
	}
}
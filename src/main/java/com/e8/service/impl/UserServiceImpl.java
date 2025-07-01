package com.e8.service.impl;

import com.e7.util.DatabaseUtil; // 关键修改：导入实验七的工具类
import com.e8.entity.User;
import com.e8.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public List<User> listUsers() {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM user";
		// 关键修改：使用DatabaseUtil获取连接
		try (Connection conn = DatabaseUtil.getConnection();
		     PreparedStatement st = conn.prepareStatement(sql);
		     ResultSet rs = st.executeQuery()) {
			while (rs.next()) {
				User user = new User(
						rs.getString("id"),
						rs.getString("name"),
						rs.getObject("insert_time", LocalDateTime.class)
				);
				users.add(user);
			}
		} catch (SQLException e) {
			logger.severe("Failed to list users: " + e.getMessage());
			// 在实际应用中，可能需要向上抛出自定义异常
		}
		return users;
	}

	@Override
	public User getUser(String id) {
		User user = null;
		String sql = "SELECT * FROM user WHERE id=?";
		// 关键修改：使用DatabaseUtil获取连接
		try (Connection conn = DatabaseUtil.getConnection();
		     PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, id);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					user = new User(
							rs.getString("id"),
							rs.getString("name"),
							rs.getObject("insert_time", LocalDateTime.class)
					);
				}
			}
		} catch (SQLException e) {
			logger.severe("Failed to get user with id " + id + ": " + e.getMessage());
		}
		return user;
	}
}
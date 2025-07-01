package com.e8.service;

import com.e8.entity.User;
import java.util.List;

public interface UserService {
	/**
	 * 查询全部用户
	 * @return 用户列表
	 */
	List<User> listUsers();

	/**
	 * 基于ID获取指定用户
	 * @param id 用户ID
	 * @return 单个用户对象，如果找不到则返回null
	 */
	User getUser(String id);
}
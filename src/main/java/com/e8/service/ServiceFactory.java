package com.e8.service;

import com.e8.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final UserService USER_SERVICE = new UserServiceImpl();

	public static UserService getUserService() {
		return USER_SERVICE;
	}
}
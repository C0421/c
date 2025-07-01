package com.e7.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
	private static Properties properties = new Properties();

	static {
		try (InputStream is = DatabaseUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties")) {
			if (is == null) {
				throw new RuntimeException("Sorry, unable to find dbconfig.properties");
			}
			properties.load(is);
			Class.forName(properties.getProperty("jdbc.driver"));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取数据库连接 (已更新以支持TiDB Cloud的SSL连接)
	 * @return Connection对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		// --- START: 新增的SSL配置代码 ---
		// 从 resources 目录加载 JKS 信任库文件
		URL trustStoreUrl = DatabaseUtil.class.getClassLoader().getResource(properties.getProperty("jdbc.truststore.path"));
		if (trustStoreUrl == null) {
			throw new SQLException("Cannot find trust store file in resources: " + properties.getProperty("jdbc.truststore.path"));
		}

		// 在建立连接前，设置JVM系统属性，指向我们的信任库
		// 这是告诉JDBC驱动在哪里可以找到验证服务器所需的证书
		System.setProperty("javax.net.ssl.trustStore", trustStoreUrl.getPath());
		System.setProperty("javax.net.ssl.trustStorePassword", properties.getProperty("jdbc.truststore.password"));
		// --- END: 新增的SSL配置代码 ---

		try {
			// 现在可以正常建立连接了
			return DriverManager.getConnection(
					properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.user"),
					properties.getProperty("jdbc.password")
			);
		} finally {
			// 清理系统属性，避免影响应用中其他可能的网络连接
			System.clearProperty("javax.net.ssl.trustStore");
			System.clearProperty("javax.net.ssl.trustStorePassword");
		}
	}
}
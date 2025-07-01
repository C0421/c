package de.nefu.software.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
	private final Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ======================= 调试代码开始 =======================
		System.out.println("====== [DEBUG] LoginServlet doPost() 被调用 ======");

		String body = "";
		try {
			body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			System.out.println("收到的原始请求体 (Raw Body): " + body);
		} catch (Exception e) {
			System.out.println("读取请求体时发生错误: " + e.getMessage());
			e.printStackTrace();
		}

		if (body == null || body.trim().isEmpty()) {
			System.out.println("错误：请求体为空！Servlet无法获取JSON数据。");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String username = null;
		String password = null;

		try {
			Map<String, String> loginData = gson.fromJson(body, Map.class);
			if (loginData != null) {
				username = loginData.get("username");
				password = loginData.get("password");
			}
		} catch (Exception e) {
			System.out.println("GSON解析JSON时发生错误: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("解析出的用户名 (Parsed Username): " + username);
		System.out.println("解析出的密码 (Parsed Password): " + password);
		// ======================== 调试代码结束 ========================

		resp.setContentType("application/json");

		// 使用解析出的变量进行判断
		if ("admin".equals(username) && "admin".equals(password)) {
			System.out.println("验证成功 (Authentication SUCCESSFUL)");
			HttpSession session = req.getSession(true);

			session.setAttribute("user", "admin");
			session.setMaxInactiveInterval(30 * 60);
			resp.getWriter().write("{\"success\": true}");
		} else {
			System.out.println("验证失败 (Authentication FAILED)");
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			resp.getWriter().write("{\"success\": false, \"message\": \"用户名或密码错误\"}");
		}
		System.out.println("====== [DEBUG] LoginServlet doPost() 执行完毕 ======\n");
	}
}
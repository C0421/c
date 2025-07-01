package de.nefu.software.servlet;

import com.google.gson.Gson;
import de.nefu.software.bean.Comment;
import de.nefu.software.bean.News;
import de.nefu.software.data.InMemoryDataStore;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewsApiServlet extends HttpServlet {
	private final Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		String pathInfo = req.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) { // 获取新闻列表
			List<News> newsList = InMemoryDataStore.getAllNews();
			resp.getWriter().write(gson.toJson(newsList));
		} else { // 获取新闻详情及其评论 (修改点)
			try {
				int id = Integer.parseInt(pathInfo.substring(1));
				News news = InMemoryDataStore.getNewsById(id);
				if (news != null) {
					List<Comment> comments = InMemoryDataStore.getCommentsByNewsId(id);
					// 使用一个Map来封装新闻和评论
					Map<String, Object> responseData = new HashMap<>();
					responseData.put("news", news);
					responseData.put("comments", comments);
					resp.getWriter().write(gson.toJson(responseData));
				} else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} catch (NumberFormatException e) {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		News news = gson.fromJson(body, News.class);
		InMemoryDataStore.addNews(news); // <-- (备注) 向内存添加数据
		resp.setStatus(HttpServletResponse.SC_CREATED);
		resp.getWriter().write("{\"success\": true}");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathInfo = req.getPathInfo();
		try {
			int id = Integer.parseInt(pathInfo.substring(1));
			String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			News news = gson.fromJson(body, News.class);
			news.setId(id);
			InMemoryDataStore.updateNews(news); // <-- (备注) 更新内存中的数据
			resp.getWriter().write("{\"success\": true}");
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathInfo = req.getPathInfo();
		try {
			int id = Integer.parseInt(pathInfo.substring(1));
			InMemoryDataStore.deleteNews(id); // <-- (备注) 从内存删除数据
			resp.getWriter().write("{\"success\": true}");
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
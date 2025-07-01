package de.nefu.software.servlet;

import com.google.gson.Gson;
import de.nefu.software.bean.Comment;
import de.nefu.software.data.InMemoryDataStore;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class CommentApiServlet extends HttpServlet {
    private final Gson gson = new Gson();

    // 新增评论
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Comment comment = gson.fromJson(body, Comment.class);
        InMemoryDataStore.addComment(comment);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write(gson.toJson(comment)); // 返回创建的评论，方便前端展示
    }

    // 删除评论 (管理员)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getPathInfo().substring(1));
            InMemoryDataStore.deleteComment(id);
            resp.getWriter().write("{\"success\": true}");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
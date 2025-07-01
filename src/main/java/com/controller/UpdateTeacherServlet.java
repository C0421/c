package com.controller;

import com.entity.Course;
import com.entity.Teacher;
import com.entity.Title;
import com.util.DatabaseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/updateteacher")
public class UpdateTeacherServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UpdateTeacherServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tid = Integer.parseInt(req.getParameter("tid"));
        req.setAttribute("teacher", DatabaseUtils.getTeacher(tid));
        req.setAttribute("titles", DatabaseUtils.listTitles());
        req.setAttribute("courses", DatabaseUtils.listCourses());
        req.getRequestDispatcher("/WEB-INF/jsp/updateteacher.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int tid = Integer.parseInt(req.getParameter("tid"));
        String name = req.getParameter("name");
        int titleId = Integer.parseInt(req.getParameter("titleid"));
        String[] courseIds = req.getParameterValues("courseids");
        LocalDateTime insertTime = LocalDateTime.parse(req.getParameter("insertTime"));

        Teacher teacher = DatabaseUtils.getTeacher(tid);
        if (teacher != null) {
            teacher.setName(name);

            Title title = DatabaseUtils.listTitles().stream()
                    .filter(t -> t.getId() == titleId)
                    .findFirst()
                    .orElse(null);
            if (title != null) {
                teacher.setTitle(title);
            }

            List<Course> selectedCourses = new ArrayList<>();
            if (courseIds != null) {
                for (String courseId : courseIds) {
                    int id = Integer.parseInt(courseId);
                    DatabaseUtils.listCourses().stream()
                            .filter(c -> c.getId() == id)
                            .findFirst()
                            .ifPresent(selectedCourses::add);
                }
            }
            teacher.setCourses(selectedCourses);
            teacher.setInsertTime(insertTime);

            System.out.println("修改后的教师信息:");
            System.out.println("ID: " + teacher.getId());
            System.out.println("姓名: " + teacher.getName());
            System.out.println("职称: " + teacher.getTitle().getName());
            System.out.print("教授课程: ");
            for (Course course : teacher.getCourses()) {
                System.out.print(course.getName() + " ");
            }
            System.out.println();
            System.out.println("注册时间: " + teacher.getInsertTime());
        }

        resp.sendRedirect(req.getContextPath() + "/listteachers");
    }
}
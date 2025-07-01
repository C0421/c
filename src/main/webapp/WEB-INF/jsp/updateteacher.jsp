<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教师详细信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 60%;
            margin: 20px auto;
        }
        label {
            display: inline-block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], select {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="checkbox"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007BFF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>教师详细信息</h1>
<form action="${pageContext.request.contextPath}/updateteacher" method="post">
    <input type="hidden" name="tid" value="${teacher.id}">
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" value="${teacher.name}" required>
    <br>
    <label for="titleid">职称:</label>
    <select id="titleid" name="titleid" required>
        <c:forEach items="${titles}" var="title">
            <option value="${title.id}" ${teacher.title.id == title.id ? 'selected' : ''}>${title.name}</option>
        </c:forEach>
    </select>
    <br>
    <label>教授课程:</label><br>
    <c:forEach items="${courses}" var="course">
        <input type="checkbox" id="course_${course.id}" name="courseids" value="${course.id}"
               <c:if test="${teacher.courses.contains(course)}">checked</c:if>>
        <label for="course_${course.id}">${course.name}</label><br>
    </c:forEach>
    <br>
    <label for="insertTime">注册时间:</label>
    <input type="text" id="insertTime" name="insertTime" value="${teacher.insertTime}" readonly>
    <br>

    <input type="submit" value="提交">
</form>
<a href="${pageContext.request.contextPath}/listteachers">返回教师列表</a>
</body>
</html>
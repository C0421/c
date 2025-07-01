<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>欢迎</title>
    <style>
        body { text-align: center; padding: 50px; }
    </style>
</head>
<body>
<%
    String username = (String) request.getAttribute("username");
    out.println("<p>调试信息: username = " + username + "</p>");
%>
<h2>欢迎你，${username}！</h2>
<p>这是受保护的页面，只有登录后才能访问。</p>
</body>
</html>
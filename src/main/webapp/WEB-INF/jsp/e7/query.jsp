<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>用户详情</title>
  <style>
    body { font-family: sans-serif; margin: 2em; }
    .detail-item { margin-bottom: 1em; }
    .label { font-weight: bold; }
  </style>
</head>
<body>
<h1>用户详细信息</h1>
<c:choose>
  <c:when test="${not empty user}">
    <div class="detail-item">
      <span class="label">用户ID：</span>
      <span>${user.id}</span>
    </div>
    <div class="detail-item">
      <span class="label">用户名称：</span>
      <span>${user.name}</span>
    </div>
    <div class="detail-item">
      <span class="label">注册时间：</span>
      <span>${user.insertTime}</span>
    </div>
  </c:when>
  <c:otherwise>
    <p>未找到指定ID的用户。</p>
  </c:otherwise>
</c:choose>
<br>
<a href="${pageContext.request.contextPath}/e7/index">返回主页</a>
</body>
</html>
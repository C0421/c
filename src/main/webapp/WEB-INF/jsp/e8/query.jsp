<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户详细信息</title>
    <style>
        body { font-family: sans-serif; background-color: #f4f7f9; padding: 2em; }
        .card { max-width: 600px; margin: 2em auto; background: white; padding: 2em; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); }
        .card h1 { color: #333; border-bottom: 2px solid #007bff; padding-bottom: 0.5em; margin-bottom: 1em; }
        .detail-item { font-size: 1.1em; margin-bottom: 1em; }
        .detail-item .label { font-weight: 600; color: #555; min-width: 100px; display: inline-block; }
        .back-link { display: inline-block; margin-top: 1.5em; color: #007bff; text-decoration: none; font-weight: 600; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>
<div class="card">
    <h1>用户详细信息</h1>
    <c:choose>
        <c:when test="${not empty user}">
            <div class="detail-item"><span class="label">用户ID：</span>${user.id}</div>
            <div class="detail-item"><span class="label">用户名：</span>${user.name}</div>
            <div class="detail-item"><span class="label">添加时间：</span>${user.insertTime}</div>
        </c:when>
        <c:otherwise>
            <p>未找到该用户的信息。</p>
        </c:otherwise>
    </c:choose>

    <%-- 关键修改：添加返回链接 --%>
    <a href="${pageContext.request.contextPath}/e8/index" class="back-link">← 返回用户列表</a>
</div>
</body>
</html>
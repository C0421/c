<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%-- 动态获取部署路径作为页面基本路径，必须保留 --%>
  <c:url var="base" value="/"/>
  <base href="${base}">
  <title>E7 - 用户管理面板</title>
  <style>
    /* --- 全局与基础样式 --- */
    :root {
      --primary-blue: #007bff;
      --primary-blue-dark: #0056b3;
      --light-blue-bg: #f0f8ff;
      --border-color: #dee2e6;
      --text-color: #495057;
      --header-color: #2c3e50;
      --white-color: #ffffff;
      --shadow-color: rgba(0, 0, 0, 0.08);
      --font-family: 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif;
    }

    body {
      font-family: var(--font-family);
      background-color: var(--light-blue-bg);
      color: var(--text-color);
      margin: 0;
      padding: 2em;
      line-height: 1.6;
    }

    /* --- 容器与布局 --- */
    .container {
      max-width: 800px;
      margin: 0 auto;
      background-color: var(--white-color);
      padding: 2em;
      border-radius: 12px;
      box-shadow: 0 8px 25px var(--shadow-color);
    }

    header h1 {
      color: var(--header-color);
      text-align: center;
      margin-top: 0;
      margin-bottom: 1.5em;
      font-size: 2.2rem;
    }

    .section {
      margin-top: 2.5em;
    }

    .section h3 {
      color: var(--header-color);
      border-bottom: 2px solid var(--primary-blue);
      padding-bottom: 0.5em;
      margin-bottom: 1em;
      font-size: 1.5rem;
    }

    /* --- 用户列表样式 --- */
    .user-list {
      list-style-type: none;
      padding: 0;
    }

    .user-list-item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 1em;
      border: 1px solid var(--border-color);
      border-radius: 8px;
      margin-bottom: 0.8em;
      transition: all 0.2s ease-in-out;
    }

    .user-list-item:hover {
      border-color: var(--primary-blue);
      box-shadow: 0 4px 15px var(--shadow-color);
      transform: translateY(-2px);
    }

    .user-name {
      font-weight: 600;
      color: var(--header-color);
    }

    .details-link {
      text-decoration: none;
      color: var(--primary-blue);
      font-weight: 500;
      padding: 0.4em 0.8em;
      border-radius: 5px;
      transition: background-color 0.2s, color 0.2s;
    }

    .details-link:hover {
      background-color: var(--primary-blue);
      color: var(--white-color);
    }

    /* --- 表单样式 --- */
    .form-group {
      margin-bottom: 1.5em;
    }

    .form-group label {
      display: block;
      margin-bottom: 0.5em;
      font-weight: 600;
      color: var(--header-color);
    }

    .form-control {
      width: 100%;
      padding: 0.8em;
      font-size: 1rem;
      border: 1px solid var(--border-color);
      border-radius: 8px;
      box-sizing: border-box; /* 保证 padding 不会撑大宽度 */
      transition: border-color 0.2s, box-shadow 0.2s;
    }

    .form-control:focus {
      outline: none;
      border-color: var(--primary-blue);
      box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.25);
    }

    .submit-btn {
      display: block;
      width: 100%;
      padding: 0.9em;
      font-size: 1.1rem;
      font-weight: 600;
      color: var(--white-color);
      background: linear-gradient(135deg, var(--primary-blue), var(--primary-blue-dark));
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: all 0.3s ease;
      box-shadow: 0 4px 10px rgba(0, 123, 255, 0.3);
    }

    .submit-btn:hover {
      opacity: 0.9;
      box-shadow: 0 6px 15px rgba(0, 123, 255, 0.4);
      transform: translateY(-2px);
    }

    .submit-btn:active {
      transform: translateY(0);
      box-shadow: 0 4px 10px rgba(0, 123, 255, 0.3);
    }

  </style>
</head>
<body>

<div class="container">
  <header>
    <h1>用户管理面板</h1>
  </header>

  <main>
    <!-- 查询用户详情的部分 -->
    <section class="section">
      <h3>用户列表</h3>
      <ul class="user-list">
        <c:forEach items="${users}" var="u">
          <li class="user-list-item">
            <span class="user-name">${u.name}</span>
              <%-- 注意链接地址要与 GetUserServlet 的 @WebServlet 匹配 --%>
            <a href="e7/getuser?uid=${u.id}" class="details-link">查看详情 →</a>
          </li>
        </c:forEach>
      </ul>
    </section>

    <!-- 修改用户名的部分 -->
    <section class="section">
      <h3>更新用户信息</h3>
      <%-- 注意表单提交地址要与 UpdateUserServlet 的 @WebServlet 匹配 --%>
      <form action="e7/update" method="post">
        <div class="form-group">
          <label for="user-select">选择要修改的用户:</label>
          <select name="uid" id="user-select" class="form-control">
            <c:forEach items="${users}" var="u">
              <option value="${u.id}">${u.name}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-group">
          <label for="new-name">输入新的用户名:</label>
          <input type="text" name="name" id="new-name" class="form-control" required placeholder="例如：新名字">
        </div>

        <button type="submit" class="submit-btn">确认修改</button>
      </form>
    </section>
  </main>
</div>

</body>
</html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <c:url var="base" value="/"/>
    <base href="${base}">
    <meta charset="UTF-8">
    <title>MVC 实验 - 用户列表</title>
    <style>
        /* 保持原有样式，仅做微调 */
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: sans-serif; }
        .container { display: flex; flex-direction: column; min-height: 100vh; }
        #main { flex-grow: 1; display: flex; padding: 10px 0; }
        #article { flex-grow: 1; margin: 0 15px; }
        #sidebar { margin: 0 15px; }
        table { width: 100%; border-collapse: collapse; }
        table thead { background-color: #337ab7; color: white; }
        table th, table td { padding: 12px; text-align: center; border: 1px solid #ddd; }
        table tbody tr:nth-child(even) { background-color: #f2f2f2; }
        table tbody tr:hover { background-color: #e9ecef; }
        a.btn { display: inline-block; background-color: #007bff; color: white; padding: 8px 12px; text-decoration: none; border-radius: 5px; transition: background-color 0.2s; }
        a.btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<div class="container">
    <div id="header">
        <%-- 关键修改：更新路径 --%>
        <jsp:include page="/WEB-INF/jsp/e8/header.jsp" />
    </div>
    <div id="main">
        <div id="sidebar">
            <%-- 关键修改：更新路径 --%>
            <jsp:include page="/WEB-INF/jsp/e8/sidebar.jsp" />
        </div>
        <div id="article">
            <h2>用户列表</h2>
            <br>
            <table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>姓名</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="u" varStatus="v">
                    <tr>
                        <td>${v.count}</td>
                        <td>${u.name}</td>
                        <td>
                                <%-- 关键修改：更新链接路径 --%>
                            <a class="btn" href="e8/getuser?uid=${u.id}">详细信息</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div id="footer">
        <%-- 关键修改：更新路径 --%>
        <jsp:include page="/WEB-INF/jsp/e8/footer.jsp" />
    </div>
</div>
</body>
</html>
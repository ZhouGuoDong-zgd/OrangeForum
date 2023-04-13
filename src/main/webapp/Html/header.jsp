<%--
  Created by IntelliJ IDEA.
  User: ViewTW
  Date: 2023-04-12
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部资源</title>
</head>
<body>
<header class="header">
    <div class="logo">橘子贴吧</div>
    <nav class="nav">
        <ul>
            <li><a href="/Html/UserHome.jsp">首页</a></li>
            <li><a href="/Html/PersonalCenter.jsp">我的</a></li>
            <li><a href="/LoginOut">退出</a></li>

        </ul>
        <form action="#" method="get">
            <input type="text" name="search" placeholder="功能尚在开发中...">
            <button type="submit">搜索</button>
        </form>
    </nav>
</header>
</body>
</html>

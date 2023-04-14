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
<style>
    .header{
        background-color: #fca728;
        border-radius: 10px;
        margin-top: 10px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
    }
    .logo{
        font-weight: 1000;
        color: #ffffff;
    }
    .FontColor {
        color: #ffffff;
    }
</style>
<body>

<header class="header">
    <div class="logo">橘子贴吧</div>
    <nav class="nav">
        <ul>
            <li><a href="/Html/UserHome.jsp"><span class="FontColor">首页</span></a></li>
            <li><a href="/Html/PersonalCenter.jsp"><span class="FontColor">我的</span></a></li>
            <li><a href="/LoginOut"><span class="FontColor">退出</span></a></li>
        </ul>
    </nav>
</header>
<script src="../js/JqueryExploit.js"></script>
<script>

</script>
</body>
</html>

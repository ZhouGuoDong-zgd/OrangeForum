<%--
  Created by IntelliJ IDEA.
  User: ViewTW
  Date: 2023-04-10
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>

<script src="../js/JqueryExploit.js"></script>
<script>
    $(function () {
        $("#username").blur(function () {
            let v = $(this).val();
            if (v == null || v == ""){
                alert("用户名不能为空")
                return;
            }
            $.get("/SearchUser",{name:v},function (value) {
                if (value=="用户已注册"){
                    alert(value)
                    return;
                }
            },"json");
        })
        $("#submin").click(function () {
            let username = $("#username").val();
            let password = $("#password").val();
            if (username == null || username == ""){
                alert("用户名不能为空")
                return;
            }
            if (password == null || password == ""){
                alert("密码不能为空")
                return;
            }
        })
    })
</script>
    <style>
        @import url("../css/register.css");
    </style>
</head>
<body style="background-color: #ff9900">
<div class="container">
    <h1>注册</h1>
    <form method="post" action="/Register">
        <label for="username">用户名</label>
        <input type="text" id="username" name="username" placeholder="请输入5至10位的数字或字母">
        <label for="password">密码</label>
        <input type="password" id="password" name="password" placeholder="请输入密码">
        <button type="submit" id="submin">注册</button>
        <p><a href="/index.jsp">返回登录界面</a></p>
    </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ViewTW
  Date: 2023-04-10
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    String username = "";
    String password = "";
    if (cookies!=null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")){
                username = cookie.getValue();
            }
            if (cookie.getName().equals("password")){
                password = cookie.getValue();
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>橘子论坛</title>
    <script src="../js/JqueryExploit.js"></script>
    <script>
        $(function (){
            $("#submit").click(function () {
                let username = $("#username").val();
                let password = $("#password").val();
                let RememberMe = $("#RememberMe").val();
                /*let regex = /^[a-zA-Z0-9]{5,10}$/*/
                if (username == null || username == ""){
                    alert("用户名或密码不能为空")
                    return;
                }
                if (password == null || password == ""){
                    alert("用户名或密码不能为空")
                    return;
                }
                $.post("/login",{"username":username,"password":password,"memory":RememberMe},function (state){
                    if (state[0]=="登入成功"){
                        location.href = "Html/UserHome.jsp"
                    }else {
                        alert("用户名或密码错误")
                    }
                },"json");
            });

        })
    </script>
    <style>
        @import "css/login.css";
    </style>
</head>
<body style="background-color: #ff9900">
<div class="container">
    <h1>登录</h1>
    <form method="post">
        <label for="username">用户名</label>
        <input type="text" id="username"   name="username" placeholder="请输入用户名" value="<%=username%>">
        <label for="password">密码</label>
        <input type="password" id="password" name="password" placeholder="请输入密码" value="<%=password%>">
        <button id="submit">登录</button>
        <input id="RememberMe" type="checkbox" name="memory">记住密码？
    </form>
    <p>没有账号？<a href="/Html/Register.jsp">点击注册</a></p>
</div>

</body>
</html>


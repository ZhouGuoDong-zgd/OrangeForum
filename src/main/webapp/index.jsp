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
    <style>
        .background{
            background-color: #fca728;
            width: 500px;
            height: 700px;
            margin: 0 auto;
            margin-top: 40px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container{
            margin: 0 auto;
            margin-top: 40px;
        }

        .container {
            margin: auto;
            max-width: 440px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #f90;
        }

        input[type=text], input[type=password] {
            width: 100%;
            height: 40px;
            padding: 10px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 440px;
            height: 40px;
            background-color: #f90;
            color: #fff;
            padding: 10px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="background">
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
</div>
</body>
<script>
    /*赋予登录按钮一个点击事件*/
        $("#submit").click(function () {
            let username = $("#username").val();
            if (username == null || username == ""){
                alert("用户名或密码不能为空")
                return;
            }
            let password = $("#password").val();
            if (password == null || password == ""){
                alert("用户名或密码不能为空")
                return;
            }
            let RememberMe = $("#RememberMe").val();
            /*let regex = /^[a-zA-Z0-9]{5,10}$/*/
            $.post("/login",{"username":username,"password":password,"memory":RememberMe},function (state){
                if (state[0]=="登入成功"){
                    location.href = "Html/UserHome.jsp"
                }else {
                    alert("用户名或密码错误")
                }
            },"json");
        });
</script>
</html>

